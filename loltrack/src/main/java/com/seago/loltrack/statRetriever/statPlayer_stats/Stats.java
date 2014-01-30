
package com.seago.loltrack.statRetriever.statPlayer_stats;


class Stats{
   	private String statType;
   	private Number value;

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
