package com.seago.loltrack;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public class ActivityPlayer extends ActivityBase {
    private static final String DTAG = "PlayerActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.v("PlayerActivity", "PlayerActivity OnCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        // Sets up action bar
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        // Log.v(DTAG, "Setting title to: " + Player.getSummoner().getData().getName());
        // actionBar.setTitle(Player.getSummoner().getData().getName());
        actionBar.setTitle("Dyrus");
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Finds if the screen is dual pane
        View fragment_profile = this.findViewById(R.id.fragment_profile);
        boolean dualPane = fragment_profile != null && fragment_profile.getVisibility() == View.VISIBLE;
        Log.v(DTAG, "dualPane: " + dualPane);

        // Adds the navigation tabs
        ActionBar.Tab tab;

        if (!dualPane) {
            tab = actionBar.newTab().setText("Profile").setTabListener(new PlayerTabListener<FragmentProfile>(FragmentProfile.class));
            actionBar.addTab(tab);
        }

        tab = actionBar.newTab().setText("Stats").setTabListener(new PlayerTabListener<FragmentRankedStats>(FragmentRankedStats.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Leagues").setTabListener(new PlayerTabListener<FragmentLeagues>(FragmentLeagues.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Matches").setTabListener(new PlayerTabListener<FragmentMatches>(FragmentMatches.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Runes").setTabListener(new PlayerTabListener<FragmentRunes>(FragmentRunes.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Masteries").setTabListener(new PlayerTabListener<FragmentMasteries>(FragmentMasteries.class));
        actionBar.addTab(tab);

        if (savedInstanceState == null) {
            // If its single pane, add the profile fragment
            if (dualPane) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_content, new FragmentRankedStats());
                ft.commit();
            }
        } else {
            int tabIndex = savedInstanceState.getInt("tabIndex", -1);
            if (tabIndex > -1)
                actionBar.setSelectedNavigationItem(tabIndex);
        }
    }

    // If an item in the action bar is selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go back
                super.onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("tabIndex", getActionBar().getSelectedNavigationIndex());
    }
}
