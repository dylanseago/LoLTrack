package com.seago.loltrack;

import android.preference.PreferenceManager;

import android.os.Bundle;

import android.view.Menu;
import android.widget.SearchView;

public class ActivityMain extends ActivityBase {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
		searchView.setFocusable(true);
		searchView.setIconified(false);
		searchView.requestFocusFromTouch();

		// Hides the title in the action bar
		getActionBar().setDisplayShowTitleEnabled(false);
		return true;
	}
}
