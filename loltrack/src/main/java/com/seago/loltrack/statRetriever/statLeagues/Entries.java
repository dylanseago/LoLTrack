
package com.seago.loltrack.statRetriever.statLeagues;


class Entries{
   	private boolean freshBlood;
   	private boolean hotStreak;
   	private boolean inactive;
   	private Number lastPlayed;
   	private Number leaguePoints;
   	private Number losses;
   	private String playerOrTeamId;
   	private String playerOrTeamName;
   	private Number previousDayLeaguePosition;
   	private String queueType;
   	private String rank;
   	private String tier;
   	private boolean veteran;
   	private Number wins;

 	public boolean getFreshBlood(){
		return this.freshBlood;
	}
	public void setFreshBlood(boolean freshBlood){
		this.freshBlood = freshBlood;
	}
 	public boolean getHotStreak(){
		return this.hotStreak;
	}
	public void setHotStreak(boolean hotStreak){
		this.hotStreak = hotStreak;
	}
 	public boolean getInactive(){
		return this.inactive;
	}
	public void setInactive(boolean inactive){
		this.inactive = inactive;
	}
 	public Number getLastPlayed(){
		return this.lastPlayed;
	}
	public void setLastPlayed(Number lastPlayed){
		this.lastPlayed = lastPlayed;
	}
 	public Number getLeaguePoints(){
		return this.leaguePoints;
	}
	public void setLeaguePoints(Number leaguePoints){
		this.leaguePoints = leaguePoints;
	}
 	public Number getLosses(){
		return this.losses;
	}
	public void setLosses(Number losses){
		this.losses = losses;
	}
 	public String getPlayerOrTeamId(){
		return this.playerOrTeamId;
	}
	public void setPlayerOrTeamId(String playerOrTeamId){
		this.playerOrTeamId = playerOrTeamId;
	}
 	public String getPlayerOrTeamName(){
		return this.playerOrTeamName;
	}
	public void setPlayerOrTeamName(String playerOrTeamName){
		this.playerOrTeamName = playerOrTeamName;
	}
 	public Number getPreviousDayLeaguePosition(){
		return this.previousDayLeaguePosition;
	}
	public void setPreviousDayLeaguePosition(Number previousDayLeaguePosition){
		this.previousDayLeaguePosition = previousDayLeaguePosition;
	}
 	public String getQueueType(){
		return this.queueType;
	}
	public void setQueueType(String queueType){
		this.queueType = queueType;
	}
 	public String getRank(){
		return this.rank;
	}
	public void setRank(String rank){
		this.rank = rank;
	}
 	public String getTier(){
		return this.tier;
	}
	public void setTier(String tier){
		this.tier = tier;
	}
 	public boolean getVeteran(){
		return this.veteran;
	}
	public void setVeteran(boolean veteran){
		this.veteran = veteran;
	}
 	public Number getWins(){
		return this.wins;
	}
	public void setWins(Number wins){
		this.wins = wins;
	}
}
