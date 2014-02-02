package com.seago.loltrack;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

class CardMatch extends CardGeneral {
	public CardMatch(ArrayList<ResourceValueMap> viewValueMap) {
		super(R.layout.card_matches_game, viewValueMap);
	}

	@Override
	public View getCardContent(View view) {
        view = super.getCardContent(view);

		TextView tv = (TextView) view.findViewById(R.id.outcome);
		String outcome = tv.getText().toString();

		if (outcome.equals("Defeat")) {
			view.findViewById(R.id.card_content).setBackgroundResource(R.color.bgRed);
			tv.setTextColor(view.getResources().getColor(R.color.statRed));
		}
		return view;
	}
}
