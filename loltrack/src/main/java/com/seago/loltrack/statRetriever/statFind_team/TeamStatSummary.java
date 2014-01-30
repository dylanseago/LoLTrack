
package com.seago.loltrack.statRetriever.statFind_team;

import java.util.List;

public class TeamStatSummary{
   	private TeamId teamId;
   	private List<?> teamStatDetails;

 	public TeamId getTeamId(){
		return this.teamId;
	}
	public void setTeamId(TeamId teamId){
		this.teamId = teamId;
	}
 	public List<?> getTeamStatDetails(){
		return this.teamStatDetails;
	}
	public void setTeamStatDetails(List<?> teamStatDetails){
		this.teamStatDetails = teamStatDetails;
	}
}
