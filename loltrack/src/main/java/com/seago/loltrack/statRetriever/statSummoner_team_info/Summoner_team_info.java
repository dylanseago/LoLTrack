package com.seago.loltrack.statRetriever.statSummoner_team_info;

import java.util.HashMap;
import java.util.Map;

import com.seago.loltrack.statRetriever.Resource;

public class Summoner_team_info extends Resource {
	private Data				data;
	private Map<String, Object>	additionalProperties	= new HashMap<String, Object>();

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperties(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
