
package com.seago.loltrack.statRetriever.statFind_team;

import java.util.List;

public class Data{
   	private String createDate;
   	private String lastGameDate;
   	private String lastJoinDate;
   	private List<?> matchHistory;
   	private String modifyDate;
   	private String name;
   	private Roster roster;
   	private String secondLastJoinDate;
   	private Number secondsUntilEligibleForDeletion;
   	private String status;
   	private String tag;
   	private TeamStatSummary teamStatSummary;
   	private String thirdLastJoinDate;

 	public String getCreateDate(){
		return this.createDate;
	}
	public void setCreateDate(String createDate){
		this.createDate = createDate;
	}
 	public String getLastGameDate(){
		return this.lastGameDate;
	}
	public void setLastGameDate(String lastGameDate){
		this.lastGameDate = lastGameDate;
	}
 	public String getLastJoinDate(){
		return this.lastJoinDate;
	}
	public void setLastJoinDate(String lastJoinDate){
		this.lastJoinDate = lastJoinDate;
	}
 	public List<?> getMatchHistory(){
		return this.matchHistory;
	}
	public void setMatchHistory(List<?> matchHistory){
		this.matchHistory = matchHistory;
	}
 	public String getModifyDate(){
		return this.modifyDate;
	}
	public void setModifyDate(String modifyDate){
		this.modifyDate = modifyDate;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public Roster getRoster(){
		return this.roster;
	}
	public void setRoster(Roster roster){
		this.roster = roster;
	}
 	public String getSecondLastJoinDate(){
		return this.secondLastJoinDate;
	}
	public void setSecondLastJoinDate(String secondLastJoinDate){
		this.secondLastJoinDate = secondLastJoinDate;
	}
 	public Number getSecondsUntilEligibleForDeletion(){
		return this.secondsUntilEligibleForDeletion;
	}
	public void setSecondsUntilEligibleForDeletion(Number secondsUntilEligibleForDeletion){
		this.secondsUntilEligibleForDeletion = secondsUntilEligibleForDeletion;
	}
 	public String getStatus(){
		return this.status;
	}
	public void setStatus(String status){
		this.status = status;
	}
 	public String getTag(){
		return this.tag;
	}
	public void setTag(String tag){
		this.tag = tag;
	}
 	public TeamStatSummary getTeamStatSummary(){
		return this.teamStatSummary;
	}
	public void setTeamStatSummary(TeamStatSummary teamStatSummary){
		this.teamStatSummary = teamStatSummary;
	}
 	public String getThirdLastJoinDate(){
		return this.thirdLastJoinDate;
	}
	public void setThirdLastJoinDate(String thirdLastJoinDate){
		this.thirdLastJoinDate = thirdLastJoinDate;
	}
}
