package com.seago.loltrack;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentMatches extends Fragment {

    public FragmentMatches() {
        super();
    }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_matches, container, false);

        LCardAdapter cardAdapter = new LCardAdapter(this.getActivity());

		ArrayList<ResourceValueMap> rvm = new ArrayList<ResourceValueMap>();

		rvm.add(new ResourceValueMap(null, R.id.icon, "champion_icon_diana"));
		rvm.add(new ResourceValueMap(null, R.id.outcome, "Victory"));
		rvm.add(new ResourceValueMap(null, R.id.mode, "Normal 5v5"));
		rvm.add(new ResourceValueMap(null, R.id.timeSince, "20 hours ago"));
		rvm.add(new ResourceValueMap(null, R.id.length, "30:41"));
		rvm.add(new ResourceValueMap(null, R.id.kda, "11/5/8"));
		rvm.add(new ResourceValueMap(null, R.id.gold, "11.2k"));
		rvm.add(new ResourceValueMap(null, R.id.minions, "146"));
        cardAdapter.add(new CardMatch(rvm));
		rvm = new ArrayList<ResourceValueMap>();
		
		rvm.add(new ResourceValueMap(null, R.id.icon, "champion_icon_jayce"));
		rvm.add(new ResourceValueMap(null, R.id.outcome, "Defeat"));
		rvm.add(new ResourceValueMap(null, R.id.mode, "Ranked 5v5"));
		rvm.add(new ResourceValueMap(null, R.id.timeSince, "1 day ago"));
		rvm.add(new ResourceValueMap(null, R.id.length, "44:25"));
		rvm.add(new ResourceValueMap(null, R.id.kda, "11/10/16"));
		rvm.add(new ResourceValueMap(null, R.id.gold, "15.8k"));
		rvm.add(new ResourceValueMap(null, R.id.minions, "257"));
        cardAdapter.add(new CardMatch(rvm));
		rvm = new ArrayList<ResourceValueMap>();

		rvm.add(new ResourceValueMap(null, R.id.icon, "champion_icon_ahri"));
		rvm.add(new ResourceValueMap(null, R.id.outcome, "Victory"));
		rvm.add(new ResourceValueMap(null, R.id.mode, "Ranked 5v5"));
		rvm.add(new ResourceValueMap(null, R.id.timeSince, "1 day ago"));
		rvm.add(new ResourceValueMap(null, R.id.length, "31:31"));
		rvm.add(new ResourceValueMap(null, R.id.kda, "4/4/11"));
		rvm.add(new ResourceValueMap(null, R.id.gold, "10.8k"));
		rvm.add(new ResourceValueMap(null, R.id.minions, "171"));
        cardAdapter.add(new CardMatch(rvm));
		rvm = new ArrayList<ResourceValueMap>();

		rvm.add(new ResourceValueMap(null, R.id.icon, "champion_icon_diana"));
		rvm.add(new ResourceValueMap(null, R.id.outcome, "Victory"));
		rvm.add(new ResourceValueMap(null, R.id.mode, "Normal 5v5"));
		rvm.add(new ResourceValueMap(null, R.id.timeSince, "1 day ago"));
		rvm.add(new ResourceValueMap(null, R.id.length, "20:30"));
		rvm.add(new ResourceValueMap(null, R.id.kda, "7/3/6"));
		rvm.add(new ResourceValueMap(null, R.id.gold, "8.2k"));
		rvm.add(new ResourceValueMap(null, R.id.minions, "119"));
        cardAdapter.add(new CardMatch(rvm));
		rvm = new ArrayList<ResourceValueMap>();

		rvm.add(new ResourceValueMap(null, R.id.icon, "champion_icon_leesin"));
		rvm.add(new ResourceValueMap(null, R.id.outcome, "Defeat"));
		rvm.add(new ResourceValueMap(null, R.id.mode, "Normal 5v5"));
		rvm.add(new ResourceValueMap(null, R.id.timeSince, "1 day ago"));
		rvm.add(new ResourceValueMap(null, R.id.length, "52:59"));
		rvm.add(new ResourceValueMap(null, R.id.kda, "2/9/7"));
		rvm.add(new ResourceValueMap(null, R.id.gold, "12.6k"));
		rvm.add(new ResourceValueMap(null, R.id.minions, "125"));
        cardAdapter.add(new CardMatch(rvm));

        LCardListView cardListView = (LCardListView) view.findViewById(R.id.cardListView);
        cardListView.setAdapter(cardAdapter);

		return view;
	}
}
