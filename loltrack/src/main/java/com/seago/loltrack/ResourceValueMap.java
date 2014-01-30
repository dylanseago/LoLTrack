package com.seago.loltrack;


class ResourceValueMap {
	private Integer	layoutId;
	private Integer	resourceId;
	private String	value;

	public ResourceValueMap(Integer layoutId, Integer resourceId, String value) {
		this.setLayoutId(layoutId);
		this.setResourceId(resourceId);
		this.setValue(value);
	}

	public ResourceValueMap(Integer layoutId, double value) {
		this.setLayoutId(layoutId);
		this.setResourceId(R.id.KDA);
		this.setValue(Utils.formatDouble(value));
	}

	public ResourceValueMap(Integer layoutId, Integer resourceId, int value) {
		this.setLayoutId(layoutId);
		this.setResourceId(resourceId);
		this.setValue(Utils.formatInteger(value));
	}

	public ResourceValueMap(Integer layoutId, Integer resourceId) {
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