package com.seago.loltrack.statRetriever.statChampions;

import java.util.List;

import com.seago.loltrack.statRetriever.Resource;

public class Champions extends Resource {
	private List<Data>	data;

	public List<Data> getData() {
		return this.data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}
}
