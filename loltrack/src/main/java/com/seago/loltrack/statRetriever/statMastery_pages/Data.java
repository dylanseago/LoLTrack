package com.seago.loltrack.statRetriever.statMastery_pages;

import java.util.List;

public class Data {
	private List<?>	bookPages;
	private String			dateString;
	private Number			summonerId;

	public List<?> getBookPages() {
		return this.bookPages;
	}

	public void setBookPages(List<?> bookPages) {
		this.bookPages = bookPages;
	}

	public String getDateString() {
		return this.dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public Number getSummonerId() {
		return this.summonerId;
	}

	public void setSummonerId(Number summonerId) {
		this.summonerId = summonerId;
	}
}
