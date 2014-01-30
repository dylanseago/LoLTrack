package com.seago.loltrack.statRetriever.statSummoner_team_info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamStatSummary {

	private List<TeamStatDetail>	teamStatDetails			= new ArrayList<TeamStatDetail>();
	private TeamId					teamId;
	private Map<String, Object>		additionalProperties	= new HashMap<String, Object>();

	public List<TeamStatDetail> getTeamStatDetails() {
		return teamStatDetails;
	}

	public void setTeamStatDetails(List<TeamStatDetail> teamStatDetails) {
		this.teamStatDetails = teamStatDetails;
	}

	public TeamId getTeamId() {
		return teamId;
	}

	public void setTeamId(TeamId teamId) {
		this.teamId = teamId;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperties(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
