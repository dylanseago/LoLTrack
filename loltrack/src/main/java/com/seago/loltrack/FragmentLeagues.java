package com.seago.loltrack;

import android.view.LayoutInflater;
import android.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class FragmentLeagues extends Fragment {

    public FragmentLeagues() {
        super();
    }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_leagues, container, false);
	}
}
