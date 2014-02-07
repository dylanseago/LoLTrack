package com.seago.loltrack;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.seago.loltrack.CardsUI.CardBase;

import java.util.ArrayList;

class CardChampionList extends CardBase {
	private ArrayList<ChampionValueMap>	championValueMap;
	private ArrayList<ChampionValueMap>	championValueMapSorted;

	public CardChampionList(ArrayList<ChampionValueMap> championValueMap) {
        super(R.layout.card_stats_champion_list);
		this.championValueMap = championValueMap;
		this.championValueMapSorted = championValueMap;
	}

	@Override
	public View getCardContent(View view) {
		LinearLayout tlView = (LinearLayout) view.findViewById(R.id.card_content);
		tlView.addView(LayoutInflater.from(view.getContext()).inflate(R.layout.card_stats_champion_list_header, null));
		tlView.addView(LayoutInflater.from(view.getContext()).inflate(R.layout.divider_basic, null));
		tlView.addView(LayoutInflater.from(view.getContext()).inflate(R.layout.divider_basic, null));

        for (ChampionValueMap aChampionValueMapSorted : championValueMapSorted) {
            LinearLayout trView = (LinearLayout) LayoutInflater.from(view.getContext()).inflate(R.layout.card_stats_champion_list_row, null);

            if (aChampionValueMapSorted.get("standing") != null)
                ((TextView) trView.findViewById(R.id.standing)).setText(aChampionValueMapSorted.get("standing"));
            else
                trView.findViewById(R.id.standing).setVisibility(View.GONE);

            ((ImageView) trView.findViewById(R.id.championIcon))
                    .setImageResource(Utils.getDrawableResource("champion_icon_" + aChampionValueMapSorted.get("name")));
            ((TextView) trView.findViewById(R.id.championName)).setText(aChampionValueMapSorted.get("name"));
            ((TextView) trView.findViewById(R.id.winPercent)).setText(aChampionValueMapSorted.get("winPercent"));
            ((TextView) trView.findViewById(R.id.games)).setText(aChampionValueMapSorted.get("games"));
            tlView.addView(trView);
            tlView.addView(LayoutInflater.from(view.getContext()).inflate(R.layout.divider_basic, null));
        }
		return view;
	}

	public void sortReset() {
		this.championValueMapSorted = championValueMap;
	}

	public void sortByRole(int roleId) {
        //TODO Implement
        this.championValueMapSorted = championValueMap;
	}
}
