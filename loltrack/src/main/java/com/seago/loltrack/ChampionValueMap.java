package com.seago.loltrack;

import java.util.HashMap;

public class ChampionValueMap extends HashMap<String, String> {
	private static final long	serialVersionUID	= 1L;

	public ChampionValueMap(Integer standing, String name, Double winPercent, Integer games) {
		if (standing != null)
			this.put("standing", Integer.toString(standing));
		else
			this.put("standing", null);
		this.put("name", name);
		this.put("winPercent", Double.toString(winPercent));
		this.put("games", Integer.toString(games));
	}
}
