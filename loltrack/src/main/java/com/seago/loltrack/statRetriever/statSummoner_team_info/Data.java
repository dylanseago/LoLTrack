
package com.seago.loltrack.statRetriever.statSummoner_team_info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Data {

    private int playerId;
    private List<TeamsSummary> teamsSummary = new ArrayList<TeamsSummary>();
    private List<CreatedTeam> createdTeams = new ArrayList<CreatedTeam>();
    private List<PlayerTeam> playerTeams = new ArrayList<PlayerTeam>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public List<TeamsSummary> getTeamsSummary() {
        return teamsSummary;
    }

    public void setTeamsSummary(List<TeamsSummary> teamsSummary) {
        this.teamsSummary = teamsSummary;
    }

    public List<CreatedTeam> getCreatedTeams() {
        return createdTeams;
    }

    public void setCreatedTeams(List<CreatedTeam> createdTeams) {
        this.createdTeams = createdTeams;
    }

    public List<PlayerTeam> getPlayerTeams() {
        return playerTeams;
    }

    public void setPlayerTeams(List<PlayerTeam> playerTeams) {
        this.playerTeams = playerTeams;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperties(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
