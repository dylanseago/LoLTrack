package com.seago.loltrack;


class MapResourceValues {
    private Integer layoutId;
    private Integer resourceId;
    private String value;

    public MapResourceValues(Integer layoutId, Integer resourceId, String value) {
        this.setLayoutId(layoutId);
        this.setResourceId(resourceId);
        this.setValue(value);
    }

    public MapResourceValues(Integer layoutId, Integer resourceId, double value) {
        this.setLayoutId(layoutId);
        this.setResourceId(resourceId);
        if (resourceId == R.id.KDA) {
            this.setValue(Utils.formatDouble(value));
        } else {
            this.setValue(Utils.formatInteger((int) value));
        }
    }

    public MapResourceValues(Integer layoutId, Integer resourceId) {
        this.setLayoutId(layoutId);
        this.setResourceId(resourceId);
        this.setValue(null);
    }

    public Integer getResourceId() {
        return resourceId;
    }

    void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getValue() {
        return value;
    }

    void setValue(String value) {
        this.value = value;
    }

    public Integer getLayoutId() {
        return layoutId;
    }

    void setLayoutId(Integer layoutId) {
        this.layoutId = layoutId;
    }
}
