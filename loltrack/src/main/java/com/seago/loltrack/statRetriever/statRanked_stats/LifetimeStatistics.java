
package com.seago.loltrack.statRetriever.statRanked_stats;


public class LifetimeStatistics{
   	private Number championId;
   	private String statType;
   	private Number value;

 	public Number getChampionId(){
		return this.championId;
	}
	public void setChampionId(Number championId){
		this.championId = championId;
	}
 	public String getStatType(){
		return this.statType;
	}
	public void setStatType(String statType){
		this.statType = statType;
	}
 	public Number getValue(){
		return this.value;
	}
	public void setValue(Number value){
		this.value = value;
	}
}
