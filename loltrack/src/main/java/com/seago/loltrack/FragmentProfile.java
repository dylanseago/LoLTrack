package com.seago.loltrack;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seago.loltrack.CardsUI.CardAdapter;
import com.seago.loltrack.CardsUI.CardListView;

public class FragmentProfile extends Fragment {

    public FragmentProfile() {
        super();
    }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflates the layout
		View view = inflater.inflate(R.layout.fragment_profile, container, false);

        CardAdapter cardAdapter = new CardAdapter(this.getActivity());

		// Sets the values for the header card
		{
			// values for each view (images and text)
			LayoutAdapter layoutAdapter = new LayoutAdapter();
			layoutAdapter.add(R.id.summonerIcon, "profile_icon534");
            layoutAdapter.add(R.id.summonerName, "Dyrus");
            layoutAdapter.add(R.id.summonerLevel, 30);

			cardAdapter.add(new CardGeneral(R.layout.card_profile_header, layoutAdapter));
		}

		// Sets the values for the ranked stats card
		{
			// values for each view (images and text)
            LayoutAdapter rankedSoloAdapter = new LayoutAdapter();
            rankedSoloAdapter.add(R.id.queue, "Solo");
            rankedSoloAdapter.add(R.id.crest, "crest_diamond_i");
            rankedSoloAdapter.add(R.id.league, "Diamond I");
            rankedSoloAdapter.add(R.id.lp, "55 LP");
            rankedSoloAdapter.add(R.id.wins, 119);
            rankedSoloAdapter.add(R.id.losses, 88);
            rankedSoloAdapter.add(R.id.KDA, 3.14);
            rankedSoloAdapter.add(R.id.lastPlayedLabel);
            rankedSoloAdapter.add(R.id.lastPlayed);


            LayoutAdapter ranked3v3Adapter = new LayoutAdapter();
            ranked3v3Adapter.add(R.id.queue, "3v3");
            ranked3v3Adapter.add(R.id.crest, "crest_unranked");
            ranked3v3Adapter.add(R.id.league, "Unranked");
            ranked3v3Adapter.add(R.id.lp);
            ranked3v3Adapter.add(R.id.winsLabel);
            ranked3v3Adapter.add(R.id.wins);
            ranked3v3Adapter.add(R.id.lossesLabel);
            ranked3v3Adapter.add(R.id.losses);
            ranked3v3Adapter.add(R.id.KDALabel);
            ranked3v3Adapter.add(R.id.KDA);
            ranked3v3Adapter.add(R.id.lastPlayedLabel);
            ranked3v3Adapter.add(R.id.lastPlayed);

            LayoutAdapter ranked5v5Adapter = new LayoutAdapter();
			ranked5v5Adapter.add(R.id.queue, "5v5");
			ranked5v5Adapter.add(R.id.crest, "crest_gold_v");
			ranked5v5Adapter.add(R.id.league, "Gold V");
			ranked5v5Adapter.add(R.id.lp, "19 LP");
			ranked5v5Adapter.add(R.id.wins, 12);
			ranked5v5Adapter.add(R.id.losses, 8);
			ranked5v5Adapter.add(R.id.KDA, 2.55);
			ranked5v5Adapter.add(R.id.lastPlayedLabel);
			ranked5v5Adapter.add(R.id.lastPlayed);

            LayoutAdapter layoutAdapter = new LayoutAdapter();
            layoutAdapter.add(R.id.ranked3v3, ranked3v3Adapter);
            layoutAdapter.add(R.id.rankedSolo, rankedSoloAdapter);
            layoutAdapter.add(R.id.ranked5v5, ranked5v5Adapter);

			cardAdapter.add(new CardGeneral(R.layout.card_profile_ranked_stats, layoutAdapter));
		}

		// Sets the values for the normal stats card
		{
			// values for each view (images and text)
			LayoutAdapter TTAdapter = new LayoutAdapter();
            TTAdapter.add(R.id.map, "3v3");
            TTAdapter.add(R.id.crest, "crest_bronze_v");
            TTAdapter.add(R.id.wins, 0);
            TTAdapter.add(R.id.kills, 11);
            TTAdapter.add(R.id.lastPlayed, "2 months ago");

            LayoutAdapter SRAdapter = new LayoutAdapter();
            SRAdapter.add(R.id.map, "Classic");
            SRAdapter.add(R.id.crest, "crest_challenger");
            SRAdapter.add(R.id.wins, 1366);
            SRAdapter.add(R.id.kills, 15464);
            SRAdapter.add(R.id.lastPlayed, "1 hour ago");

            LayoutAdapter CSAdapter = new LayoutAdapter();
            CSAdapter.add(R.id.map, "Dominion");
            CSAdapter.add(R.id.crest, "crest_bronze_v");
            CSAdapter.add(R.id.wins, 40);
            CSAdapter.add(R.id.killsLabel, "Max Score: ");
            CSAdapter.add(R.id.kills, 2190);
            CSAdapter.add(R.id.lastPlayed, "1 month ago");

            LayoutAdapter layoutAdapter = new LayoutAdapter();
            layoutAdapter.add(R.id.twistedTreeline, TTAdapter);
            layoutAdapter.add(R.id.summonersRift, SRAdapter);
            layoutAdapter.add(R.id.crystalScar, CSAdapter);

			cardAdapter.add(new CardGeneral(R.layout.card_profile_normal_stats, layoutAdapter));
		}

		// Sets the values for the champion stats card
		{
			// values for each view (images and text)
			LayoutAdapter[] cAdapter = new LayoutAdapter[5];
            for (int i = 0; i < cAdapter.length; i++)
                cAdapter[i] = new LayoutAdapter();

			cAdapter[0].add(R.id.summonerName, "Jayce");
			cAdapter[0].add(R.id.summonerIcon, "champion_icon_jayce");
			cAdapter[0].add(R.id.winPercent, "58%");
			cAdapter[0].add(R.id.games, 60);

			cAdapter[1].add(R.id.summonerName, "Singed");
			cAdapter[1].add(R.id.summonerIcon, "champion_icon_singed");
			cAdapter[1].add(R.id.winPercent, "61%");
			cAdapter[1].add(R.id.games, 38);

			cAdapter[2].add(R.id.summonerName, "Graves");
			cAdapter[2].add(R.id.summonerIcon, "champion_icon_graves");
			cAdapter[2].add(R.id.winPercent, "56%");
			cAdapter[2].add(R.id.games, 45);

			cAdapter[3].add(R.id.summonerName, "Brand");
			cAdapter[3].add(R.id.summonerIcon, "champion_icon_brand");
			cAdapter[3].add(R.id.winPercent, "63%");
			cAdapter[3].add(R.id.games, 16);

			cAdapter[4].add(R.id.summonerName, "Taric");
			cAdapter[4].add(R.id.summonerIcon, "champion_icon_taric");
			cAdapter[4].add(R.id.winPercent, "55%");
			cAdapter[4].add(R.id.games, 20);

            LayoutAdapter layoutAdapter = new LayoutAdapter();
            layoutAdapter.add(R.id.championOne, cAdapter[0]);
            layoutAdapter.add(R.id.championTwo, cAdapter[1]);
            layoutAdapter.add(R.id.championThree, cAdapter[2]);
            layoutAdapter.add(R.id.championFour, cAdapter[3]);
            layoutAdapter.add(R.id.championFive, cAdapter[4]);

			cardAdapter.add(new CardGeneral(R.layout.card_profile_champion_stats, layoutAdapter));
		}

        CardListView cardListView = (CardListView) view.findViewById(R.id.cardListView);
        cardListView.setAdapter(cardAdapter);

		return view;
	}
}
