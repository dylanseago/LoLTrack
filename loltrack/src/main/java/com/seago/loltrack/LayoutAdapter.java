package com.seago.loltrack;

import android.view.View;

import java.util.ArrayList;

/**
 * Maps a value for a view to be set to.
 */
class LayoutAdapter {
    private ArrayList<ViewMap> viewMaps = new ArrayList<ViewMap>();

    /**
     * Adds a mapping that sets the {@code value} of a view by its {@code resourceId} to
     * {@code null}.
     *
     * @param resourceId The {@link Integer} id of the element.
     */
    public void add(Integer resourceId) {
        viewMaps.add(new ViewMap(resourceId));
    }

    /**
     * Adds a mapping that sets the {@code value} of a view by its {@code resourceId}.
     *
     * @param resourceId The {@link Integer} id of the element.
     * @param value      The {@link String} {@code value} to set the element to.
     */
    public void add(Integer resourceId, String value) {
        viewMaps.add(new ViewMap(resourceId, value));
    }

    /**
     * Adds a mapping that sets the {@code value} of a view by its {@code resourceId}.
     *
     * @param resourceId The {@link Integer} id of the element.
     * @param value      The {@link Double} {@code value} to set the element to.
     */
    public void add(Integer resourceId, Double value) {
        viewMaps.add(new ViewMap(resourceId, value));
    }

    /**
     * Adds a mapping that sets the {@code value} of a view by its {@code resourceId}.
     *
     * @param resourceId The {@link Integer} id of the element.
     * @param value      The {@link Integer} {@code value} to set the element to.
     */
    public void add(Integer resourceId, Integer value) {
        viewMaps.add(new ViewMap(resourceId, value));
    }

    /**
     * Adds a mapping that sets the {@code values} of views within {@code layoutId} to the values
     * that the {@link LayoutAdapter} has mapped.
     *
     * @param layoutId      The {@link Integer} id of the layout.
     * @param layoutAdapter The {@link LayoutAdapter} to set the layout to.
     */
    public void add(Integer layoutId, LayoutAdapter layoutAdapter) {
        for (ViewMap viewMap : layoutAdapter.viewMaps) {
            ArrayList<Integer> layoutIds = viewMap.getLayoutIds();
            if (layoutIds != null) {
                layoutIds.add(0, layoutId);
            } else {
                layoutIds = new ArrayList<Integer>();
                layoutIds.add(layoutId);
                viewMap.setLayoutIds(layoutIds);
            }
            this.viewMaps.add(viewMap);
        }
    }

    /**
     * Returns the total number of views mapped in this adapter.
     *
     * @return Total views mapped in this adapter.
     */
    public int getViewCount() {
        return this.viewMaps.size();
    }

    /**
     * Returns the {@code View} contained within the {@code parentView} specified by its
     * {@code index} in this adapter.
     *
     * @param parentView The parent {@code View} that the child {@code View} is contained within.
     * @param index      The index of the {@code View} in this adapter.
     * @return The {@code View} contained within the {@code parentView} specified by its
     * {@code index} in this adapter.
     */
    public View getView(View parentView, int index) {
        View view = parentView;
        ViewMap viewMap = this.viewMaps.get(index);
        if (viewMap.getLayoutIds() != null) {
            for (int layoutId : viewMap.getLayoutIds()) {
                view = view.findViewById(layoutId);
            }
        }
        return view.findViewById(viewMap.getViewId());
    }

    /**
     * Gets the {@code value} that the {@code View} at {@code index} has been mapped to.
     *
     * @param index The {@code index} of the {@code View} in this adapter.
     * @return The {@code value} of the {@code View}.
     */
    public String getViewValue(int index) {
        return this.viewMaps.get(index).getValue();
    }
}
