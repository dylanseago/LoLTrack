package com.seago.loltrack;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.seago.loltrack.CardsUI.CardBase;

import java.util.ArrayList;

class CardLeagueList extends CardBase {
	private ArrayList<ChampionValueMap>	championValueMap;
	private ArrayList<ChampionValueMap>	championValueMapSorted;

	public CardLeagueList() {
        super(R.layout.card_list);
		//this.championValueMap = championValueMap;
		//this.championValueMapSorted = championValueMap;
	}

	@Override
	public View getCardContent(View view) {
        LinearLayout listView = (LinearLayout) view.findViewById(R.id.card_content);
        listView.addView(LayoutInflater.from(view.getContext()).inflate(R.layout.card_leagues_list_header, null));
        listView.addView(LayoutInflater.from(view.getContext()).inflate(R.layout.divider_basic, null));
        listView.addView(LayoutInflater.from(view.getContext()).inflate(R.layout.divider_basic, null));
        for (int i = 0; i < 30; i++) {
            listView.addView(LayoutInflater.from(view.getContext()).inflate(R.layout.card_leagues_list_row, null));
            listView.addView(LayoutInflater.from(view.getContext()).inflate(R.layout.divider_basic, null));
        }
		return view;
	}
}
