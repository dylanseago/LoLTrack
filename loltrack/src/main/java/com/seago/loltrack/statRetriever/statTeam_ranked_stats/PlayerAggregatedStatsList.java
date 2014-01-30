
package com.seago.loltrack.statRetriever.statTeam_ranked_stats;


class PlayerAggregatedStatsList{
   	private AggregatedStats aggregatedStats;
   	private Number playerId;

 	public AggregatedStats getAggregatedStats(){
		return this.aggregatedStats;
	}
	public void setAggregatedStats(AggregatedStats aggregatedStats){
		this.aggregatedStats = aggregatedStats;
	}
 	public Number getPlayerId(){
		return this.playerId;
	}
	public void setPlayerId(Number playerId){
		this.playerId = playerId;
	}
}
