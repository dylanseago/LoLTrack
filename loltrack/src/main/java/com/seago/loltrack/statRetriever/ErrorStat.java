package com.seago.loltrack.statRetriever;

public class ErrorStat extends Resource {
	private String	region = null;

	public ErrorStat(String error) {
		super.success = false;
		super.error = error;
	}

	public ErrorStat(String region, String error) {
		super.success = false;
		super.error = error;
		this.region = region;
	}

	public String getRegion() {
		return this.region;
	}
}
