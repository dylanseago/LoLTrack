package com.seago.loltrack;

import android.app.Fragment;

import android.app.FragmentTransaction;
import android.util.Log;

import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;

class PlayerTabListener<T extends Fragment> implements TabListener {
	private Fragment		mFragment;
	private final Class<T>	mNewFragment;

	public PlayerTabListener(Class<T> cFrag) {
		mNewFragment = cFrag;
	}

	/* The following are each of the ActionBar.TabListener callbacks */

	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// Make new fragment to show this selection.
		try {
			mFragment = mNewFragment.newInstance();
		} catch (InstantiationException e) {
			Log.e("PlayerTabListener", "InstantiationException", e);
		} catch (IllegalAccessException e) {
			Log.e("PlayerTabListener", "IllegalAccessException", e);
		}

		// Replace the content of the activity with new fragment
		ft.replace(R.id.fragment_content, mFragment);

	}

	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		if (mFragment != null) {
			// Detach the fragment, because another one is being attached
			ft.detach(mFragment);
		}
	}

	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// User selected the already selected tab. Usually do nothing.
	}
}
