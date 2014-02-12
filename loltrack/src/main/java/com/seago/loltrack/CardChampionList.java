package com.seago.loltrack;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.seago.loltrack.CardsUI.CardBase;

import java.util.ArrayList;

class CardChampionList extends CardBase {
	private ArrayList<MapChampionStats> mapChampionStats;
	private ArrayList<MapChampionStats> mapChampionStatsSorted;

	public CardChampionList(ArrayList<MapChampionStats> mapChampionStats) {
        super(R.layout.card_list);
		this.mapChampionStats = mapChampionStats;
		this.mapChampionStatsSorted = mapChampionStats;
	}

	@Override
	public View getCardContent(View view) {
		LinearLayout tlView = (LinearLayout) view.findViewById(R.id.card_content);
		tlView.addView(LayoutInflater.from(view.getContext()).inflate(R.layout.card_stats_list_header, null));
		tlView.addView(LayoutInflater.from(view.getContext()).inflate(R.layout.divider_basic, null));
		tlView.addView(LayoutInflater.from(view.getContext()).inflate(R.layout.divider_basic, null));

        for (MapChampionStats aMapChampionStatsSorted : mapChampionStatsSorted) {
            LinearLayout trView = (LinearLayout) LayoutInflater.from(view.getContext()).inflate(R.layout.card_stats_list_row, null);

            if (aMapChampionStatsSorted.get("standing") != null)
                ((TextView) trView.findViewById(R.id.standing)).setText(aMapChampionStatsSorted.get("standing"));
            else
                trView.findViewById(R.id.standing).setVisibility(View.GONE);

            ((ImageView) trView.findViewById(R.id.summonerIcon))
                    .setImageResource(Utils.getDrawableResource("champion_icon_" + aMapChampionStatsSorted.get("name")));
            ((TextView) trView.findViewById(R.id.summonerName)).setText(aMapChampionStatsSorted.get("name"));
            ((TextView) trView.findViewById(R.id.winPercent)).setText(aMapChampionStatsSorted.get("winPercent"));
            ((TextView) trView.findViewById(R.id.games)).setText(aMapChampionStatsSorted.get("games"));
            tlView.addView(trView);
            tlView.addView(LayoutInflater.from(view.getContext()).inflate(R.layout.divider_basic, null));
        }
		return view;
	}

	public void sortReset() {
		this.mapChampionStatsSorted = mapChampionStats;
	}

	public void sortByRole(int roleId) {
        //TODO Implement
        this.mapChampionStatsSorted = mapChampionStats;
	}
}
