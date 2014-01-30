
package com.seago.loltrack.statRetriever.statPlayer_stats;


public class PlayerStatSummarySet{
   	private AggregatedStats aggregatedStats;
   	private String modifyDate;
   	private String playerStatSummaryType;
   	private Number wins;

 	public AggregatedStats getAggregatedStats(){
		return this.aggregatedStats;
	}
	public void setAggregatedStats(AggregatedStats aggregatedStats){
		this.aggregatedStats = aggregatedStats;
	}
 	public String getModifyDate(){
		return this.modifyDate;
	}
	public void setModifyDate(String modifyDate){
		this.modifyDate = modifyDate;
	}
 	public String getPlayerStatSummaryType(){
		return this.playerStatSummaryType;
	}
	public void setPlayerStatSummaryType(String playerStatSummaryType){
		this.playerStatSummaryType = playerStatSummaryType;
	}
 	public Number getWins(){
		return this.wins;
	}
	public void setWins(Number wins){
		this.wins = wins;
	}
}
