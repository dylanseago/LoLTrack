package com.seago.loltrack;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seago.loltrack.CardsUI.CardAdapter;
import com.seago.loltrack.CardsUI.CardListView;

public class FragmentLeagues extends Fragment {

    public FragmentLeagues() {
        super();
    }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_leagues, container, false);

        CardAdapter cardAdapter = new CardAdapter(this.getActivity());
        cardAdapter.add(new CardGeneral(R.layout.card_leagues_header));
        cardAdapter.add(new CardGeneral(R.layout.card_leagues_list_header));

        CardListView cardListView = (CardListView) view.findViewById(R.id.cardListView);
        cardListView.setAdapter(cardAdapter);

        return view;
	}
}
