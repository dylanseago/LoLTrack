package com.seago.loltrack;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seago.loltrack.CardsUI.CardAdapter;
import com.seago.loltrack.CardsUI.CardListView;

public class FragmentMatches extends Fragment {

    public FragmentMatches() {
        super();
    }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_matches, container, false);

        CardAdapter cardAdapter = new CardAdapter(this.getActivity());

		LayoutAdapter layoutAdapter;

        layoutAdapter = new LayoutAdapter();
		layoutAdapter.add(R.id.icon, "champion_icon_diana");
		layoutAdapter.add(R.id.outcome, "Victory");
		layoutAdapter.add(R.id.mode, "Normal 5v5");
		layoutAdapter.add(R.id.timeSince, "20 hours ago");
		layoutAdapter.add(R.id.length, "30:41");
		layoutAdapter.add(R.id.kda, "11/5/8");
		layoutAdapter.add(R.id.gold, "11.2k");
		layoutAdapter.add(R.id.minions, 146);
        cardAdapter.add(new CardMatch(layoutAdapter));

		layoutAdapter = new LayoutAdapter();
		layoutAdapter.add(R.id.icon, "champion_icon_jayce");
		layoutAdapter.add(R.id.outcome, "Defeat");
		layoutAdapter.add(R.id.mode, "Ranked 5v5");
		layoutAdapter.add(R.id.timeSince, "1 day ago");
		layoutAdapter.add(R.id.length, "44:25");
		layoutAdapter.add(R.id.kda, "11/10/16");
		layoutAdapter.add(R.id.gold, "15.8k");
		layoutAdapter.add(R.id.minions, 257);
        cardAdapter.add(new CardMatch(layoutAdapter));

		layoutAdapter = new LayoutAdapter();
		layoutAdapter.add(R.id.icon, "champion_icon_ahri");
		layoutAdapter.add(R.id.outcome, "Victory");
		layoutAdapter.add(R.id.mode, "Ranked 5v5");
		layoutAdapter.add(R.id.timeSince, "1 day ago");
		layoutAdapter.add(R.id.length, "31:31");
		layoutAdapter.add(R.id.kda, "4/4/11");
		layoutAdapter.add(R.id.gold, "10.8k");
		layoutAdapter.add(R.id.minions, 171);
        cardAdapter.add(new CardMatch(layoutAdapter));

		layoutAdapter = new LayoutAdapter();
		layoutAdapter.add(R.id.icon, "champion_icon_diana");
		layoutAdapter.add(R.id.outcome, "Victory");
		layoutAdapter.add(R.id.mode, "Normal 5v5");
		layoutAdapter.add(R.id.timeSince, "1 day ago");
		layoutAdapter.add(R.id.length, "20:30");
		layoutAdapter.add(R.id.kda, "7/3/6");
		layoutAdapter.add(R.id.gold, "8.2k");
		layoutAdapter.add(R.id.minions, 119);
        cardAdapter.add(new CardMatch(layoutAdapter));

		layoutAdapter = new LayoutAdapter();
		layoutAdapter.add(R.id.icon, "champion_icon_leesin");
		layoutAdapter.add(R.id.outcome, "Defeat");
		layoutAdapter.add(R.id.mode, "Normal 5v5");
		layoutAdapter.add(R.id.timeSince, "1 day ago");
		layoutAdapter.add(R.id.length, "52:59");
		layoutAdapter.add(R.id.kda, "2/9/7");
		layoutAdapter.add(R.id.gold, "12.6k");
		layoutAdapter.add(R.id.minions, 125);
        cardAdapter.add(new CardMatch(layoutAdapter));

        CardListView cardListView = (CardListView) view.findViewById(R.id.cardListView);
        cardListView.setAdapter(cardAdapter);

		return view;
	}
}
