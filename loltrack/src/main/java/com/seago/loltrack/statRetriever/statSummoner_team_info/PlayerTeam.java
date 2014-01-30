
package com.seago.loltrack.statRetriever.statSummoner_team_info;

import java.util.HashMap;
import java.util.Map;

class PlayerTeam {

    private String tag;
    private String name;
    private TeamId teamId;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
