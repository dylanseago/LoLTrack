package com.seago.loltrack;

import android.app.SearchManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.seago.loltrack.CardsUI.CardAdapter;
import com.seago.loltrack.CardsUI.CardBase;
import com.seago.loltrack.CardsUI.CardListView;
import com.seago.loltrack.statRetriever.ErrorCardBase;
import com.seago.loltrack.statRetriever.ErrorStat;
import com.seago.loltrack.statRetriever.Player;
import com.seago.loltrack.statRetriever.statLeagues.Leagues;
import com.seago.loltrack.statRetriever.statPlayer_stats.Player_stats;
import com.seago.loltrack.statRetriever.statRanked_stats.Ranked_stats;
import com.seago.loltrack.statRetriever.statSummoner.Summoner;
import com.seago.loltrack.statRetriever.statSummoner_team_info.Summoner_team_info;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class ActivitySearch extends ActivityBase {
    private static final String DTAG = "SearchActivity";
    private CardAdapter searchResultsAdapter;
    private ProgressBar progressBar;
    private boolean searchNA;
    private boolean searchEUW;
    private boolean searchEUNE;
    private boolean searchBR;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // TODO Fix researching on screen rotate
        getActionBar().setDisplayHomeAsUpEnabled(true);

        // init ProgressBar
        progressBar = (ProgressBar) findViewById(R.id.searchResultsProgressBar);

        handleIntent(getIntent());
    }

    @Override
    public void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }

    // If an item in the action bar is selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go back
                super.onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Retrieves the users preferences for searching
    private void getPreferences() {
        // Gets search preferences
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        searchNA = sp.getBoolean("searchNA", true);
        searchEUW = sp.getBoolean("searchEUW", true);
        searchEUNE = sp.getBoolean("searchEUNE", true);
        searchBR = sp.getBoolean("searchBR", true);

        // If regional searches are all false; set all to true
        if (!searchNA && !searchEUW && !searchEUNE && !searchBR) {
            searchNA = true;
            searchEUW = true;
            searchEUNE = true;
            searchBR = true;
        }
    }

    // Handles this activities intent
    private void handleIntent(Intent intent) {
        // init CardView
        searchResultsAdapter = new CardAdapter(this);
        ((CardListView) findViewById(R.id.cardListView)).setAdapter(searchResultsAdapter);

        getPreferences();

        // Gets the search query and performs a search
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Log.v(DTAG, "doSummonerSearch: " + query);
            doSummonerSearch(query);
        }
    }

    // Searches for a summoner
    void doSummonerSearch(String query) {
        // TODO Remove after done testing
        SummonerInfoTest info1 = new SummonerInfoTest("NA");
        CardBase c1 = new CardSummonerTest(info1);
        c1.setCardClickListener(new CardSearchClickListener());
        SummonerInfoTest info2 = new SummonerInfoTest("EU");
        CardBase c2 = new CardSummonerTest(info2);
        c2.setCardClickListener(new CardSearchClickListener());

        searchResultsAdapter.add(c1);
        searchResultsAdapter.add(c2);
        progressBar.setVisibility(View.GONE);

		/*
        // Checks for null query
		if (query == null)
			throwErrorCard("Search query is null.");
		else {
			try {
				// Checks if the device is connected to a network
				ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
				NetworkInfo netInfo = connMgr.getActiveNetworkInfo();

				if (netInfo != null && netInfo.isConnected()) {
					new StatRetriever().execute(query);
				} else {
					throwErrorCard("No network connection is available.");
				}
			} catch (Exception e) {
				throwErrorCard("Failed to obtain network info.");
			}
		}
		*/
    }

    // Reports a specified error visually and in the logs
    public void throwErrorCard(String message) {
        Log.e(DTAG, message);
        searchResultsAdapter.add(new ErrorCardBase(new ErrorStat(message)));
    }

    // In the background retrieves the URL for specified resource and converts the JSON into an object and displays the result
    public class StatRetriever extends AsyncTask<String, Integer, ArrayList<CardBase>> {
        private Gson gson = new Gson();
        private String query;

        // Before the AsyncTask begins its operation
        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }

        // When the AsyncTask begins its operation
        @Override
        protected ArrayList<CardBase> doInBackground(String... query) {
            this.query = urlEncode(query[0]);
            ArrayList<CardBase> result = new ArrayList<CardBase>();

            // Checks if the preference has been enabled for searching in the specified region then adds the card for that region to the CardUI
            if (searchNA)
                result.add(getSummonerCard("NA"));
            if (searchEUW)
                result.add(getSummonerCard("EUW"));
            if (searchEUNE)
                result.add(getSummonerCard("EUNE"));
            if (searchBR)
                result.add(getSummonerCard("BR"));

            return result;
        }

        // After the AsyncTask has completed its operation
        @Override
        protected void onPostExecute(ArrayList<CardBase> res) {
            for (CardBase re : res) {
                searchResultsAdapter.add(re);
            }
            progressBar.setVisibility(View.GONE);
        }

        // Gets the statistics for search query and specified region
        private CardBase getSummonerCard(String region) {
            Summoner summoner;
            Player_stats player_stats;
            Ranked_stats ranked_stats;
            Leagues leagues;
            Summoner_team_info summoner_team_info;

            // Downloads the statistics
            try {
                // Gets Summoner using specified query
                String urlSummoner = "http://api.elophant.com/v2/" + region + "/summoner/" + query + "?key=" + Utils.API_KEY;
                String jsonSummoner = downloadUrl(urlSummoner);
                summoner = gson.fromJson(jsonSummoner, Summoner.class);

                // Checks to see if specified summoner exists, if not, return an error
                if (!summoner.getSuccess())
                    return new ErrorCardBase(new ErrorStat(region, summoner.getError()));

                // Gets Player_stats using resSummoner.SummonerId
                String urlPlayer_stats = "http://api.elophant.com/v2/" + region + "/player_stats/" + summoner.getData().getAcctId() + "?key=" + Utils.API_KEY;
                String jsonPlayer_stats = downloadUrl(urlPlayer_stats);
                player_stats = gson.fromJson(jsonPlayer_stats, Player_stats.class);

                // Gets Ranked_stats using resSummoner.AcctId
                String urlRanked_stats = "http://api.elophant.com/v2/" + region + "/ranked_stats/" + summoner.getData().getAcctId() + "/current?key=" + Utils.API_KEY;
                String jsonRanked_stats = downloadUrl(urlRanked_stats);
                ranked_stats = gson.fromJson(jsonRanked_stats, Ranked_stats.class);

                // Gets Leagues using resSummoner.SummonerId
                String urlLeagues = "http://api.elophant.com/v2/" + region + "/leagues/" + summoner.getData().getSummonerId() + "?key=" + Utils.API_KEY;
                String jsonLeagues = downloadUrl(urlLeagues);
                leagues = gson.fromJson(jsonLeagues, Leagues.class);

                // Gets Leagues using resSummoner.SummonerId
                String urlSummoner_team_info = "http://api.elophant.com/v2/" + region + "/leagues/" + summoner.getData().getSummonerId() + "?key=" + Utils.API_KEY;
                String jsonSummoner_team_info = downloadUrl(urlSummoner_team_info);
                summoner_team_info = gson.fromJson(jsonSummoner_team_info, Summoner_team_info.class);

            } catch (IOException e) {
                return new ErrorCardBase(new ErrorStat("Unable to retrieve stats. Server may be offline."));
            } catch (Exception e) {
                return new ErrorCardBase(new ErrorStat("Unknown error retrieving stats."));
            }

            // Converts statistics to a player object
            Player player = new Player(region);
            player.setSummoner(summoner);
            player.setPlayer_stats(player_stats);
            player.setRanked_stats(ranked_stats);
            player.setLeagues(leagues);
            player.setSummoner_team_info(summoner_team_info);

            // Passes the player into a SummonerCardInfo object which gathers the required stats from the json objects to be easily displayed on a card
            SummonerInfo info = new SummonerInfo(player);
            CardBase c = new CardSummoner(info);
            c.setCardClickListener(new CardSearchClickListener(player));

            return c;
        }

        // Encodes a url to be used as a web address
        private String urlEncode(String url) {
            try {
                return URLEncoder.encode(url, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                return url;
            }
        }

        // Given a URL, establishes an HttpUrlConnection and retrieves
        // the web page content as a InputStream, which it returns as a string.
        private String downloadUrl(String urlString) throws IOException {
            InputStream inputStream = null;
            // Only display the first 'len' characters of the retrieved web page content.
            int len = 1024;
            try {
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setReadTimeout(10000 /* milliseconds */);
                connection.setConnectTimeout(15000 /* milliseconds */);
                connection.setRequestMethod("GET");
                connection.setDoInput(true);
                // Starts the query
                connection.connect();
                inputStream = connection.getInputStream();

                // Convert the InputStream into a string
                return readIt(inputStream, len);

                // Makes sure that the InputStream is closed after the app is finished using it.
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        }

        // Reads an InputStream and converts it to a String.
        private String readIt(InputStream stream, int len) throws IOException {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
                StringBuilder buffer = new StringBuilder();
                char[] chars = new char[len];
                int read;
                while ((read = reader.read(chars)) != -1)
                    buffer.append(chars, 0, read);
                return buffer.toString();
            } catch (Exception e) {
                return "ioerror";
            } finally {
                if (reader != null)
                    reader.close();
            }
        }

    }

    private class CardSearchClickListener implements CardListView.CardClickListener {

        private Player player;

        public CardSearchClickListener() {
            super();
        }

        public CardSearchClickListener(Player player) {
            this.player = player;
        }

        @Override
        public void onClick(int index, CardBase card, View view) {
            Intent intent = new Intent(view.getContext(), ActivityPlayer.class);
            // Serializes the player object to be passed as a string
			/*Log.v("CardOnClickListener", "Converting and Adding Json");
			String s = new Gson().toJson(player).toString();
			intent.putExtra("player", s);
			Log.v("CardOnClickListener", "Part of StringExtra: " + s.substring(0, 256));
			Log.v("CardOnClickListener", "Length of StringExtra: " + s.length());*/
            Log.v("CardOnClickListener", "Starting activity");
            view.getContext().startActivity(intent);
        }
    }
}
