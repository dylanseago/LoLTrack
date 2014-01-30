package com.seago.loltrack;

class RoleMap {
	private int		championId;
	private String	championName;
	private int[]	role;

	public RoleMap(int championId, String championName, int... role) {
		this.setChampionId(championId);
		this.setChampionName(championName);
		this.setRole(role);
	}

	public int getChampionId() {
		return championId;
	}

	void setChampionId(int championId) {
		this.championId = championId;
	}

	public String getChampionName() {
		return championName;
	}

	void setChampionName(String championName) {
		this.championName = championName;
	}

	public int[] getRoles() {
		return role;
	}

	void setRole(int[] role) {
		this.role = role;
	}
}
