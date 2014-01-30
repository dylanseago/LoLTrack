package com.seago.loltrack;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

class FragmentRankedStats extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_ranked_stats, container, false);

		LCardAdapter cardAdapter = new LCardAdapter(this.getActivity());

		CardGeneral cg = new CardGeneral(R.layout.card_stats_header, new ArrayList<ResourceValueMap>());
		cardAdapter.add(cg);

		ArrayList<ChampionValueMap> championValueMap = new ArrayList<ChampionValueMap>();
		championValueMap.add(new ChampionValueMap(1, "Jayce", 58.0, 60));
		championValueMap.add(new ChampionValueMap(2, "Singed", 55.5, 38));
		championValueMap.add(new ChampionValueMap(3, "Graves", 62.2, 45));
		championValueMap.add(new ChampionValueMap(4, "Brand", 66.7, 20));
		championValueMap.add(new ChampionValueMap(5, "Taric", 53.0, 16));
		championValueMap.add(new ChampionValueMap(6, "Udyr", 72.1, 6));
		championValueMap.add(new ChampionValueMap(7, "Sona", 59.1, 8));
		championValueMap.add(new ChampionValueMap(8, "Jarvan IV", 52.2, 9));
		championValueMap.add(new ChampionValueMap(9, "Ezreal", 48.1, 14));
		championValueMap.add(new ChampionValueMap(10, "Vladimir", 40.6, 7));
		championValueMap.add(new ChampionValueMap(11, "Nasus", 66.7, 3));
		championValueMap.add(new ChampionValueMap(12, "Caitlyn", 33.3, 4));
		championValueMap.add(new ChampionValueMap(13, "Lee Sin", 0.0, 2));
		championValueMap.add(new ChampionValueMap(105, "Evelynn", 100.0, 1));

		cardAdapter.add(new CardChampionList(championValueMap));

        LCardListView cardListView = (LCardListView) view.findViewById(R.id.cardListView);
        cardListView.setAdapter(cardAdapter);

		return view;
	}
}
