package com.seago.loltrack;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

class ActivityBase extends Activity {
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_layout, menu);

		// Sets up the search bar
		SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
		searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Starts settings and about activities
		switch (item.getItemId()) {
			case R.id.menu_settings:
				startActivity(new Intent(this, ActivitySettings.class));
				return true;
			case R.id.menu_about:
				startActivity(new Intent(this, ActivityAbout.class));
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
}
