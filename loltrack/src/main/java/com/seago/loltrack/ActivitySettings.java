package com.seago.loltrack;

import android.app.Activity;
import android.preference.PreferenceFragment;

import android.os.Bundle;

import android.view.MenuItem;

public class ActivitySettings extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		// Adds preference fragment to this activity
		getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
			case android.R.id.home:
				// app icon in action bar clicked; go back an activity
				super.onBackPressed();
				return true;
		}
		return super.onOptionsItemSelected(item);
	}

	// Fragment containing preferences
    private class SettingsFragment extends PreferenceFragment {
		@Override
		public void onCreate(final Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			addPreferencesFromResource(R.xml.preferences);
		}
	}
}
