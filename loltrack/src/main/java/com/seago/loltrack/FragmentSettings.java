package com.seago.loltrack;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Fragment containing preferences
 */
public class FragmentSettings extends PreferenceFragment {

    int xml;

    public FragmentSettings() {
        super();
    }

    public FragmentSettings(int xml) {
        this();
        this.xml = xml;
    }

    @Override
    public void onActivityCreated(final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null)
            this.xml = savedInstanceState.getInt("xml");

        addPreferencesFromResource(this.xml);
    }

    @Override
    public void onSaveInstanceState(final Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("xml", this.xml);
    }
}
