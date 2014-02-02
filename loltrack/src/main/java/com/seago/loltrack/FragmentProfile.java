package com.seago.loltrack;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentProfile extends Fragment {

    public FragmentProfile() {
        super();
    }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflates the layout
		View view = inflater.inflate(R.layout.fragment_profile, container, false);

        LCardAdapter cardAdapter = new LCardAdapter(this.getActivity());
        cardAdapter.setCardsClickable(false);

		// Sets the values for the header card
		{
			// layout
			int layoutId = R.layout.card_profile_header;

			// values for each view (images and text)
			ArrayList<ResourceValueMap> viewValueMap = new ArrayList<ResourceValueMap>();

			// String summonerIcon = "profile_icon" + Data.player.getSummoner().getData().getProfileIconId();
			String summonerIcon = "profile_icon534";
			viewValueMap.add(new ResourceValueMap(null, R.id.summonerIcon, summonerIcon));

			// String summonerName = Data.player.getSummoner().getData().getName();
			String summonerName = "Dyrus";
			viewValueMap.add(new ResourceValueMap(null, R.id.summonerName, summonerName));

			// String summonerLevel = Data.player.getRegion() + " - Level " + Data.player.getSummoner().getData().getSummonerLevel().intValue();
			String summonerLevel = "30";
			viewValueMap.add(new ResourceValueMap(null, R.id.summonerLevel, summonerLevel));

			CardGeneral card = new CardGeneral(layoutId, viewValueMap);
			cardAdapter.add(card);
		}

		// Sets the values for the ranked stats card
		{
			int layoutId = R.layout.card_profile_ranked_stats;

			// values for each view (images and text)
			ArrayList<ResourceValueMap> viewValueMap = new ArrayList<ResourceValueMap>();

			viewValueMap.add(new ResourceValueMap(R.id.ranked3v3, R.id.queue, "3v3"));
			viewValueMap.add(new ResourceValueMap(R.id.ranked3v3, R.id.crest, "crest_unranked"));
			viewValueMap.add(new ResourceValueMap(R.id.ranked3v3, R.id.league, "Unranked"));
			viewValueMap.add(new ResourceValueMap(R.id.ranked3v3, R.id.lp));
			viewValueMap.add(new ResourceValueMap(R.id.ranked3v3, R.id.winsLabel));
			viewValueMap.add(new ResourceValueMap(R.id.ranked3v3, R.id.wins));
			viewValueMap.add(new ResourceValueMap(R.id.ranked3v3, R.id.lossesLabel));
			viewValueMap.add(new ResourceValueMap(R.id.ranked3v3, R.id.losses));
			viewValueMap.add(new ResourceValueMap(R.id.ranked3v3, R.id.KDALabel));
			viewValueMap.add(new ResourceValueMap(R.id.ranked3v3, R.id.KDA));
			viewValueMap.add(new ResourceValueMap(R.id.ranked3v3, R.id.lastPlayedLabel));
			viewValueMap.add(new ResourceValueMap(R.id.ranked3v3, R.id.lastPlayed));

			viewValueMap.add(new ResourceValueMap(R.id.rankedSolo, R.id.queue, "Solo"));
			viewValueMap.add(new ResourceValueMap(R.id.rankedSolo, R.id.crest, "crest_diamond_i"));
			viewValueMap.add(new ResourceValueMap(R.id.rankedSolo, R.id.league, "Diamond I"));
			viewValueMap.add(new ResourceValueMap(R.id.rankedSolo, R.id.lp, "55 LP"));
			viewValueMap.add(new ResourceValueMap(R.id.rankedSolo, R.id.wins, 119));
			viewValueMap.add(new ResourceValueMap(R.id.rankedSolo, R.id.losses, 88));
			viewValueMap.add(new ResourceValueMap(R.id.rankedSolo, R.id.KDA, 3.14));
			viewValueMap.add(new ResourceValueMap(R.id.rankedSolo, R.id.lastPlayedLabel));
			viewValueMap.add(new ResourceValueMap(R.id.rankedSolo, R.id.lastPlayed));

			viewValueMap.add(new ResourceValueMap(R.id.ranked5v5, R.id.queue, "5v5"));
			viewValueMap.add(new ResourceValueMap(R.id.ranked5v5, R.id.crest, "crest_gold_v"));
			viewValueMap.add(new ResourceValueMap(R.id.ranked5v5, R.id.league, "Gold V"));
			viewValueMap.add(new ResourceValueMap(R.id.ranked5v5, R.id.lp, "19 LP"));
			viewValueMap.add(new ResourceValueMap(R.id.ranked5v5, R.id.wins, 12));
			viewValueMap.add(new ResourceValueMap(R.id.ranked5v5, R.id.losses, 8));
			viewValueMap.add(new ResourceValueMap(R.id.ranked5v5, R.id.KDA, 2.55));
			viewValueMap.add(new ResourceValueMap(R.id.ranked5v5, R.id.lastPlayedLabel));
			viewValueMap.add(new ResourceValueMap(R.id.ranked5v5, R.id.lastPlayed));

			CardGeneral card = new CardGeneral(layoutId, viewValueMap);
			cardAdapter.add(card);

		}

		// Sets the values for the normal stats card
		{
			int layoutId = R.layout.card_profile_normal_stats;

			// values for each view (images and text)
			ArrayList<ResourceValueMap> viewValueMap = new ArrayList<ResourceValueMap>();

			viewValueMap.add(new ResourceValueMap(R.id.twistedTreeline, R.id.map, "3v3"));
			viewValueMap.add(new ResourceValueMap(R.id.twistedTreeline, R.id.crest, "crest_bronze_v"));
			viewValueMap.add(new ResourceValueMap(R.id.twistedTreeline, R.id.wins, 0));
			viewValueMap.add(new ResourceValueMap(R.id.twistedTreeline, R.id.kills, 11));
			viewValueMap.add(new ResourceValueMap(R.id.twistedTreeline, R.id.lastPlayed, "2 months ago"));

			viewValueMap.add(new ResourceValueMap(R.id.summonersRift, R.id.map, "Classic"));
			viewValueMap.add(new ResourceValueMap(R.id.summonersRift, R.id.crest, "crest_challenger"));
			viewValueMap.add(new ResourceValueMap(R.id.summonersRift, R.id.wins, 1366));
			viewValueMap.add(new ResourceValueMap(R.id.summonersRift, R.id.kills, 15464));
			viewValueMap.add(new ResourceValueMap(R.id.summonersRift, R.id.lastPlayed, "1 hour ago"));

			viewValueMap.add(new ResourceValueMap(R.id.crystalScar, R.id.map, "Dominion"));
			viewValueMap.add(new ResourceValueMap(R.id.crystalScar, R.id.crest, "crest_bronze_v"));
			viewValueMap.add(new ResourceValueMap(R.id.crystalScar, R.id.wins, 40));
			viewValueMap.add(new ResourceValueMap(R.id.crystalScar, R.id.killsLabel, "Max Score: "));
			viewValueMap.add(new ResourceValueMap(R.id.crystalScar, R.id.kills, 2190));
			viewValueMap.add(new ResourceValueMap(R.id.crystalScar, R.id.lastPlayed, "1 month ago"));

			CardGeneral card = new CardGeneral(layoutId, viewValueMap);
			cardAdapter.add(card);

		}

		// Sets the values for the champion stats card
		{
			int layoutId = R.layout.card_profile_champion_stats;

			// values for each view (images and text)
			ArrayList<ResourceValueMap> viewValueMap = new ArrayList<ResourceValueMap>();

			viewValueMap.add(new ResourceValueMap(R.id.championOne, R.id.championName, "Jayce"));
			viewValueMap.add(new ResourceValueMap(R.id.championOne, R.id.championIcon, "champion_icon_jayce"));
			viewValueMap.add(new ResourceValueMap(R.id.championOne, R.id.winPercent, "58%"));
			viewValueMap.add(new ResourceValueMap(R.id.championOne, R.id.games, 60));

			viewValueMap.add(new ResourceValueMap(R.id.championTwo, R.id.championName, "Singed"));
			viewValueMap.add(new ResourceValueMap(R.id.championTwo, R.id.championIcon, "champion_icon_singed"));
			viewValueMap.add(new ResourceValueMap(R.id.championTwo, R.id.winPercent, "61%"));
			viewValueMap.add(new ResourceValueMap(R.id.championTwo, R.id.games, 38));

			viewValueMap.add(new ResourceValueMap(R.id.championThree, R.id.championName, "Graves"));
			viewValueMap.add(new ResourceValueMap(R.id.championThree, R.id.championIcon, "champion_icon_graves"));
			viewValueMap.add(new ResourceValueMap(R.id.championThree, R.id.winPercent, "56%"));
			viewValueMap.add(new ResourceValueMap(R.id.championThree, R.id.games, 45));

			viewValueMap.add(new ResourceValueMap(R.id.championFour, R.id.championName, "Brand"));
			viewValueMap.add(new ResourceValueMap(R.id.championFour, R.id.championIcon, "champion_icon_brand"));
			viewValueMap.add(new ResourceValueMap(R.id.championFour, R.id.winPercent, "63%"));
			viewValueMap.add(new ResourceValueMap(R.id.championFour, R.id.games, 16));

			viewValueMap.add(new ResourceValueMap(R.id.championFive, R.id.championName, "Taric"));
			viewValueMap.add(new ResourceValueMap(R.id.championFive, R.id.championIcon, "champion_icon_taric"));
			viewValueMap.add(new ResourceValueMap(R.id.championFive, R.id.winPercent, "55%"));
			viewValueMap.add(new ResourceValueMap(R.id.championFive, R.id.games, 20));

			CardGeneral card = new CardGeneral(layoutId, viewValueMap);
			cardAdapter.add(card);

		}

        LCardListView cardListView = (LCardListView) view.findViewById(R.id.cardListView);
        cardListView.setAdapter(cardAdapter);

		return view;
	}
}
