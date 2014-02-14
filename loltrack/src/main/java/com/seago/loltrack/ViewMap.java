package com.seago.loltrack;

import java.util.ArrayList;

/**
 * A tool that is used to map an {@code id} of an element to a certain {@link String} value.
 * Optionally, multiple layouts can be specified if the element is nested within them.
 */
class ViewMap {
    private ArrayList<Integer> layoutIds;
    private Integer viewId;
    private String value = null;

    /**
     * Creates a new object mapping a resource specified by its {@code viewId} to its
     * corresponding {@link String} {@code value} which is set to {@code null}
     *
     * @param viewId {@link Integer} id of the resource to map
     */
    public ViewMap(Integer viewId) {
        this.setViewId(viewId);
    }

    /**
     * Creates a new object mapping a resource specified by its {@code viewId} to its
     * corresponding {@link String} {@code value}
     *
     * @param viewId {@link Integer} id of the resource to map
     * @param value      {@link String} value to set the specified resource to
     */
    public ViewMap(Integer viewId, String value) {
        this(viewId);
        this.setValue(value);
    }

    /**
     * Creates a new object mapping a resource specified by its {@code viewId} to its
     * corresponding {@link Double} {@code value}
     *
     * @param viewId {@link Integer} id of the resource to map
     * @param value      {@link Double} value to set the specified resource to
     */
    public ViewMap(Integer viewId, Double value) {
        this(viewId, Utils.formatDouble(value));
    }

    /**
     * Creates a new object mapping a resource specified by its {@code viewId} to its
     * corresponding {@link Integer} {@code value}
     *
     * @param viewId {@link Integer} id of the resource to map
     * @param value      {@link Integer} value to set the specified resource to
     */
    public ViewMap(Integer viewId, Integer value) {
        this(viewId, Utils.formatInteger(value));
    }

    /**
     * Creates a new object mapping a resource specified by its {@code viewId} that is nested
     * inside the layouts specified by the {@code layoutIds} array to its corresponding
     * {@link String} {@code value}
     *
     * @param viewId {@link Integer} id of the resource to map
     * @param value      {@link String} value to set the specified resource to
     * @param layoutIds   {@link Integer} array of layout id's corresponding to the location
     *                   of the specified {@code viewId}
     */
    public ViewMap(Integer viewId, String value, ArrayList<Integer> layoutIds) {
        this(viewId, value);
        this.setLayoutIds(layoutIds);
    }

    /**
     * Creates a new object mapping a resource specified by its {@code viewId} that is nested
     * inside the layouts specified by the {@code layoutIds} array to its corresponding
     * {@link Double} {@code value}
     *
     * @param viewId {@link Integer} id of the resource to map
     * @param value      {@link Double} value to set the specified resource to
     * @param layoutIds   {@link Integer} array of layout id's corresponding to the location
     *                   of the specified {@code viewId}
     */
    public ViewMap(Integer viewId, Double value, ArrayList<Integer> layoutIds) {
        this(viewId, Utils.formatDouble(value), layoutIds);
    }

    /**
     * Creates a new object mapping a resource specified by its {@code viewId} that is nested
     * inside the layouts specified by the {@code layoutIds} array to its corresponding
     * {@link Integer} {@code value}
     *
     * @param viewId {@link Integer} id of the resource to map
     * @param value      {@link Integer} value to set the specified resource to
     * @param layoutIds   {@link Integer} array of layout id's corresponding to the location
     *                   of the specified {@code viewId}
     */
    public ViewMap(Integer viewId, Integer value, ArrayList<Integer> layoutIds) {
        this(viewId, Utils.formatInteger(value), layoutIds);
    }

    /**
     * The {@code viewId} is the id of an element will be set to a specified {@code value}
     * @return The {@link Integer} id of the resource being mapped
     */
    public Integer getViewId() {
        return viewId;
    }

    /**
     * The {@code viewId} is the id of an element will be set to a specified {@code value}
     * @param viewId The {@link Integer} id of the resource being mapped
     */
    public ViewMap setViewId(Integer viewId) {
        assert viewId != null;
        this.viewId = viewId;
        return this;
    }

    /**
     * The {@code value} is the {@link String} that the specified {@code viewId} will be set to
     * @return The {@link String} {@code value} of the map
     */
    public String getValue() {
        return value;
    }

    /**
     * The {@code value} is the {@link String} that the specified {@code viewId} will be set to
     * @param value The {@link String} {@code value} of the map
     */
    public ViewMap setValue(String value) {
        this.value = value;
        return this;
    }

    /**
     * The {@code layoutIds} is the {@link Integer} array of id's where the specified
     * {@code viewId} can be located.
     * @return The {@link Integer} array of layout id's
     */
    public ArrayList<Integer> getLayoutIds() {
        return layoutIds;
    }

    /**
     * The {@code layoutIds} is the {@link Integer} array of id's where the specified
     * {@code viewId} can be located.
     * @param layoutIds The {@link Integer} array of layout id's
     */
    public ViewMap setLayoutIds(ArrayList<Integer> layoutIds) {
        this.layoutIds = layoutIds;
        return this;
    }
}
