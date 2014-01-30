package com.seago.loltrack.statRetriever.statRanked_stats;

import java.util.List;

public class Data {
	private List<LifetimeStatistics>	lifetimeStatistics;
	private String						modifyDate;

	public List<LifetimeStatistics> getLifetimeStatistics() {
		return this.lifetimeStatistics;
	}

	public void setLifetimeStatistics(List<LifetimeStatistics> lifetimeStatistics) {
		this.lifetimeStatistics = lifetimeStatistics;
	}

	public String getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
}
