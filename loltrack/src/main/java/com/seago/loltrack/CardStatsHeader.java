package com.seago.loltrack;

import android.view.View;
import android.widget.EditText;

class CardStatsHeader extends LCard {
    public CardStatsHeader(){
        super(R.layout.card_stats_header);
    }

    @Override
    public View getCardContent(View view) {
        // Setup the searchView
        EditText search = (EditText) view.findViewById(R.id.searchChampions);
        search.setFocusable(true);
        search.setFocusableInTouchMode(true);
        search.requestFocusFromTouch();
        return view;
    }
}
