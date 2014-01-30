package com.seago.loltrack.statRetriever.statLeagues;

import java.util.List;

public class SummonerLeagues {
	private List<Entries>	entries;
	private String			name;
	private String			queue;
	private String			requestorsName;
	private String			requestorsRank;
	private String			tier;

	public List<Entries> getEntries() {
		return this.entries;
	}

	public void setEntries(List<Entries> entries) {
		this.entries = entries;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQueue() {
		return this.queue;
	}

	public void setQueue(String queue) {
		this.queue = queue;
	}

	public String getRequestorsName() {
		return this.requestorsName;
	}

	public void setRequestorsName(String requestorsName) {
		this.requestorsName = requestorsName;
	}

	public String getRequestorsRank() {
		return this.requestorsRank;
	}

	public void setRequestorsRank(String requestorsRank) {
		this.requestorsRank = requestorsRank;
	}

	public String getTier() {
		return this.tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}
}
