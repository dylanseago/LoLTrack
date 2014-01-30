package com.seago.loltrack.statRetriever.statSummoner_team_info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TeamsSummary {

	private TeamStatSummary		teamStatSummary;
	private String				status;
	private String				tag;
	private Roster				roster;
	private String				lastGameDate;
	private String				modifyDate;
	private String				lastJoinDate;
	private String				secondLastJoinDate;
	private String				thirdLastJoinDate;
	private double				secondsUntilEligibleForDeletion;
	private List<MatchHistory>	matchHistory			= new ArrayList<MatchHistory>();
	private String				name;
	private String				createDate;
	private Map<String, Object>	additionalProperties	= new HashMap<String, Object>();

	public TeamStatSummary getTeamStatSummary() {
		return teamStatSummary;
	}

	public void setTeamStatSummary(TeamStatSummary teamStatSummary) {
		this.teamStatSummary = teamStatSummary;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Roster getRoster() {
		return roster;
	}

	public void setRoster(Roster roster) {
		this.roster = roster;
	}

	public String getLastGameDate() {
		return lastGameDate;
	}

	public void setLastGameDate(String lastGameDate) {
		this.lastGameDate = lastGameDate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getLastJoinDate() {
		return lastJoinDate;
	}

	public void setLastJoinDate(String lastJoinDate) {
		this.lastJoinDate = lastJoinDate;
	}

	public String getSecondLastJoinDate() {
		return secondLastJoinDate;
	}

	public void setSecondLastJoinDate(String secondLastJoinDate) {
		this.secondLastJoinDate = secondLastJoinDate;
	}

	public String getThirdLastJoinDate() {
		return thirdLastJoinDate;
	}

	public void setThirdLastJoinDate(String thirdLastJoinDate) {
		this.thirdLastJoinDate = thirdLastJoinDate;
	}

	public double getSecondsUntilEligibleForDeletion() {
		return secondsUntilEligibleForDeletion;
	}

	public void setSecondsUntilEligibleForDeletion(double secondsUntilEligibleForDeletion) {
		this.secondsUntilEligibleForDeletion = secondsUntilEligibleForDeletion;
	}

	public List<MatchHistory> getMatchHistory() {
		return matchHistory;
	}

	public void setMatchHistory(List<MatchHistory> matchHistory) {
		this.matchHistory = matchHistory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperties(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
