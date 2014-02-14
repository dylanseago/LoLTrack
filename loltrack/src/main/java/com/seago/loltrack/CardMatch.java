package com.seago.loltrack;

import android.view.View;
import android.widget.TextView;

class CardMatch extends CardGeneral {
	public CardMatch(LayoutAdapter layoutAdapter) {
		super(R.layout.card_matches_game, layoutAdapter);
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
