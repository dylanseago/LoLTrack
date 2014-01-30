
package com.seago.loltrack.statRetriever.statSummoner;


public class Data{
   	private Number acctId;
   	private String internalName;
   	private String name;
   	private Number profileIconId;
   	private String revisionDate;
   	private Number summonerId;
   	private Number summonerLevel;

 	public Number getAcctId(){
		return this.acctId;
	}
	public void setAcctId(Number acctId){
		this.acctId = acctId;
	}
 	public String getInternalName(){
		return this.internalName;
	}
	public void setInternalName(String internalName){
		this.internalName = internalName;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public Number getProfileIconId(){
		return this.profileIconId;
	}
	public void setProfileIconId(Number profileIconId){
		this.profileIconId = profileIconId;
	}
 	public String getRevisionDate(){
		return this.revisionDate;
	}
	public void setRevisionDate(String revisionDate){
		this.revisionDate = revisionDate;
	}
 	public Number getSummonerId(){
		return this.summonerId;
	}
	public void setSummonerId(Number summonerId){
		this.summonerId = summonerId;
	}
 	public Number getSummonerLevel(){
		return this.summonerLevel;
	}
	public void setSummonerLevel(Number summonerLevel){
		this.summonerLevel = summonerLevel;
	}
}
