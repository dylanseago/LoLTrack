package com.seago.loltrack.statRetriever;

import android.view.View;
import android.widget.TextView;

import com.seago.loltrack.CardsUI.CardBase;
import com.seago.loltrack.R;

public class ErrorCardBase extends CardBase {
	private boolean	success;
	private String	region;
    private String error;

	public ErrorCardBase(ErrorStat es) {
		super(R.layout.card_summoner_search);
		this.success = es.getSuccess();
		this.region = es.getRegion();
        this.error = es.getError();
	}

	public boolean getSuccess() {
		return this.success;
	}

	public String getRegion() {
		return this.region;
	}

	@Override
	public View getCardContent(View view) {

		if (region != null)
			((TextView) view.findViewById(R.id.summonerRegion)).setText(region);
		else
			view.findViewById(R.id.summonerRegion).setVisibility(View.GONE);
		
		((TextView) view.findViewById(R.id.summonerName)).setText(this.error);
		((TextView) view.findViewById(R.id.summonerName)).setTextAppearance(view.getContext(), R.style.CardTitle);
		((TextView) view.findViewById(R.id.summonerName)).setTextSize(18.0f);

		view.findViewById(R.id.summonerIcon).setVisibility(View.GONE);
		view.findViewById(R.id.summonerLevel).setVisibility(View.GONE);

		view.findViewById(R.id.underlineOne).setVisibility(View.GONE);

		view.findViewById(R.id.topRankingTitle).setVisibility(View.GONE);
		view.findViewById(R.id.topRankingImage).setVisibility(View.GONE);
		view.findViewById(R.id.topRanking).setVisibility(View.GONE);
		view.findViewById(R.id.topRankingLP).setVisibility(View.GONE);
		view.findViewById(R.id.topRankingWinsLabel).setVisibility(View.GONE);
		view.findViewById(R.id.topRankingWins).setVisibility(View.GONE);
		view.findViewById(R.id.topRankingLossesLabel).setVisibility(View.GONE);
		view.findViewById(R.id.topRankingLosses).setVisibility(View.GONE);
		view.findViewById(R.id.topRankingKDALabel).setVisibility(View.GONE);
		view.findViewById(R.id.topRankingKDA).setVisibility(View.GONE);

		view.findViewById(R.id.topChampionTitle).setVisibility(View.GONE);
		view.findViewById(R.id.topChampion).setVisibility(View.GONE);
		view.findViewById(R.id.topChampionImage).setVisibility(View.GONE);
		view.findViewById(R.id.topChampionGamesLabel).setVisibility(View.GONE);
		view.findViewById(R.id.topChampionGames).setVisibility(View.GONE);
		view.findViewById(R.id.topChampionKDALabel).setVisibility(View.GONE);
		view.findViewById(R.id.topChampionKDA).setVisibility(View.GONE);

		// Currently unused in program as well
		view.findViewById(R.id.topChampionWinsLabel).setVisibility(View.GONE);
		view.findViewById(R.id.topChampionWins).setVisibility(View.GONE);

		view.findViewById(R.id.topChampionLossesLabel).setVisibility(View.GONE);
		view.findViewById(R.id.topChampionLosses).setVisibility(View.GONE);

		view.findViewById(R.id.underlineTwo).setVisibility(View.GONE);

		view.findViewById(R.id.normalWinsLabel).setVisibility(View.GONE);
		view.findViewById(R.id.normalWins).setVisibility(View.GONE);

		return view;
	}
}
