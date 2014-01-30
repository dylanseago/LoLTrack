
package com.seago.loltrack.statRetriever.statPlayer_stats;


public class Data{
   	private PlayerStatSummaries playerStatSummaries;
   	private String previousFirstWinOfDay;
   	private Number userId;

 	public PlayerStatSummaries getPlayerStatSummaries(){
		return this.playerStatSummaries;
	}
	public void setPlayerStatSummaries(PlayerStatSummaries playerStatSummaries){
		this.playerStatSummaries = playerStatSummaries;
	}
 	public String getPreviousFirstWinOfDay(){
		return this.previousFirstWinOfDay;
	}
	public void setPreviousFirstWinOfDay(String previousFirstWinOfDay){
		this.previousFirstWinOfDay = previousFirstWinOfDay;
	}
 	public Number getUserId(){
		return this.userId;
	}
	public void setUserId(Number userId){
		this.userId = userId;
	}
}
