package com.seago.loltrack.statRetriever.statSummoner_team_info;

import java.util.HashMap;
import java.util.Map;

class TeamStatDetail {

	private int					maxRating;
	private int					seedRating;
	private int					wins;
	private int					losses;
	private int					rating;
	private String				teamStatType;
	private int					averageGamesPlayed;
	private Map<String, Object>	additionalProperties	= new HashMap<String, Object>();

	public int getMaxRating() {
		return maxRating;
	}

	public void setMaxRating(int maxRating) {
		this.maxRating = maxRating;
	}

	public int getSeedRating() {
		return seedRating;
	}

	public void setSeedRating(int seedRating) {
		this.seedRating = seedRating;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getTeamStatType() {
		return teamStatType;
	}

	public void setTeamStatType(String teamStatType) {
		this.teamStatType = teamStatType;
	}

	public int getAverageGamesPlayed() {
		return averageGamesPlayed;
	}

	public void setAverageGamesPlayed(int averageGamesPlayed) {
		this.averageGamesPlayed = averageGamesPlayed;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperties(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
