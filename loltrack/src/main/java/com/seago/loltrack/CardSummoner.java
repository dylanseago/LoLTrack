package com.seago.loltrack;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class CardSummoner extends LCard {

	private SummonerInfo	info;

	public CardSummoner(SummonerInfo summonerInfo) {
		super(R.layout.card_summoner_search);
		this.info = summonerInfo;
	}

	@Override
	public View getCardContent(View view) {
		// Sets the basic profile information for the summoner
		((TextView) view.findViewById(R.id.summonerRegion)).setText(info.region);
		try {
			((ImageView) view.findViewById(R.id.summonerIcon)).setImageResource(Utils.getDrawableResource("profile_icon" + info.summonerIconId));
		} catch (Exception e) {
			// Sets to default icon if iconId does not exist as a drawable (e.g. when new icons are added and the app isnt updated)
			((ImageView) view.findViewById(R.id.summonerIcon)).setImageResource(Utils.getDrawableResource("profile_icon_0"));
		}
		((TextView) view.findViewById(R.id.summonerName)).setText(info.name);
		((TextView) view.findViewById(R.id.summonerLevel)).setText("Level " + info.level);
		((TextView) view.findViewById(R.id.normalWins)).setText(Integer.toString(info.normalWins));

		// Sets summmoners leagues stats if given
		if (info.topRanking != null) {
			((ImageView) view.findViewById(R.id.topRankingImage)).setImageResource(Utils.getDrawableResource("crest_" + info.topRanking));
			((TextView) view.findViewById(R.id.topRanking)).setText(info.topRanking);
			((TextView) view.findViewById(R.id.topRankingWins)).setText(Integer.toString(info.topRankingWins));
			((TextView) view.findViewById(R.id.topRankingLosses)).setText(Integer.toString(info.topRankingLosses));
			((TextView) view.findViewById(R.id.topRankingKDA)).setText(Utils.formatDouble(info.topRankingKDA));

		}
		// Hides summoners leagues if not given
		else {
			((ImageView) view.findViewById(R.id.topRankingImage)).setImageResource(Utils.getDrawableResource("crest_unranked"));
			((TextView) view.findViewById(R.id.topRanking)).setText("Unranked");

			view.findViewById(R.id.topRankingWinsLabel).setVisibility(View.GONE);
			view.findViewById(R.id.topRankingWins).setVisibility(View.GONE);

			view.findViewById(R.id.topRankingLossesLabel).setVisibility(View.GONE);
			view.findViewById(R.id.topRankingLosses).setVisibility(View.GONE);

			view.findViewById(R.id.topRankingKDALabel).setVisibility(View.GONE);
			view.findViewById(R.id.topRankingKDA).setVisibility(View.GONE);
		}

		// Sets summoners top champion if given
		if (info.topChampion != null) {
			try {
				((ImageView) view.findViewById(R.id.topChampionImage)).setImageResource(Utils.getDrawableResource("champion_icon_" + info.topChampion));
			} catch (Exception e) {
				// Sets to default icon if iconId doesnt exist as a drawable
				((ImageView) view.findViewById(R.id.topChampionImage)).setImageResource(Utils.getDrawableResource("champion_icon_unknown"));
			}
			((TextView) view.findViewById(R.id.topChampion)).setText(info.topChampion);
			((TextView) view.findViewById(R.id.topChampionGames)).setText(Integer.toString(info.topChampionGames));
			((TextView) view.findViewById(R.id.topChampionKDA)).setText(Utils.formatDouble(info.topChampionKDA));
		}
		// Hides summoners top champion if not given
		else {
			((TextView) view.findViewById(R.id.topChampion)).setText("Unknown");
			((ImageView) view.findViewById(R.id.topChampionImage)).setImageResource(Utils.getDrawableResource("champion_icon_unknown"));
			
			view.findViewById(R.id.topChampionGamesLabel).setVisibility(View.GONE);
			view.findViewById(R.id.topChampionGames).setVisibility(View.GONE);

			view.findViewById(R.id.topChampionKDALabel).setVisibility(View.GONE);
			view.findViewById(R.id.topChampionKDA).setVisibility(View.GONE);
		}

		//
		// Unable to find API for these stats or they are just not being used currently
		// 			
		view.findViewById(R.id.topRankingLP).setVisibility(View.GONE);

		view.findViewById(R.id.topChampionWinsLabel).setVisibility(View.GONE);
		view.findViewById(R.id.topChampionWins).setVisibility(View.GONE);

		view.findViewById(R.id.topChampionLossesLabel).setVisibility(View.GONE);
		view.findViewById(R.id.topChampionLosses).setVisibility(View.GONE);

		return view;
	}

}
