
package com.seago.loltrack.statRetriever.statTeam_ranked_stats;

import java.util.List;

class Data{
   	private List<?> playerAggregatedStatsList;
   	private String queueType;
   	private TeamId teamId;

 	public List<?> getPlayerAggregatedStatsList(){
		return this.playerAggregatedStatsList;
	}
	public void setPlayerAggregatedStatsList(List<?> playerAggregatedStatsList){
		this.playerAggregatedStatsList = playerAggregatedStatsList;
	}
 	public String getQueueType(){
		return this.queueType;
	}
	public void setQueueType(String queueType){
		this.queueType = queueType;
	}
 	public TeamId getTeamId(){
		return this.teamId;
	}
	public void setTeamId(TeamId teamId){
		this.teamId = teamId;
	}
}
