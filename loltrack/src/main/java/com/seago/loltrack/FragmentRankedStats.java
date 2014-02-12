package com.seago.loltrack;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seago.loltrack.CardsUI.CardAdapter;
import com.seago.loltrack.CardsUI.CardListView;

import java.util.ArrayList;

public class FragmentRankedStats extends Fragment {

    public FragmentRankedStats() {
        super();
    }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_ranked_stats, container, false);

		CardAdapter cardAdapter = new CardAdapter(this.getActivity());
		cardAdapter.add(new CardStatsHeader());

		ArrayList<MapChampionStats> mapChampionStats = new ArrayList<MapChampionStats>();
		mapChampionStats.add(new MapChampionStats(1, "Jayce", 58.0, 60));
		mapChampionStats.add(new MapChampionStats(2, "Singed", 55.5, 38));
		mapChampionStats.add(new MapChampionStats(3, "Graves", 62.2, 45));
		mapChampionStats.add(new MapChampionStats(4, "Brand", 66.7, 20));
		mapChampionStats.add(new MapChampionStats(5, "Taric", 53.0, 16));
		mapChampionStats.add(new MapChampionStats(6, "Udyr", 72.1, 6));
		mapChampionStats.add(new MapChampionStats(7, "Sona", 59.1, 8));
		mapChampionStats.add(new MapChampionStats(8, "Jarvan IV", 52.2, 9));
		mapChampionStats.add(new MapChampionStats(9, "Ezreal", 48.1, 14));
		mapChampionStats.add(new MapChampionStats(10, "Vladimir", 40.6, 7));
		mapChampionStats.add(new MapChampionStats(11, "Nasus", 66.7, 3));
		mapChampionStats.add(new MapChampionStats(12, "Caitlyn", 33.3, 4));
		mapChampionStats.add(new MapChampionStats(13, "Lee Sin", 0.0, 2));
		mapChampionStats.add(new MapChampionStats(105, "Evelynn", 100.0, 1));

		cardAdapter.add(new CardChampionList(mapChampionStats));

        CardListView cardListView = (CardListView) view.findViewById(R.id.cardListView);
        cardListView.setAdapter(cardAdapter);
        cardListView.setItemsCanFocus(true);

		return view;
	}
}
