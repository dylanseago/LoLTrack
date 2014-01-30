
package com.seago.loltrack.statRetriever.statEnd_of_game_stats;

import java.util.List;

public class Data{
   	private Number basePoints;
   	private Number elo;
   	private Number eloChange;
   	private Number gameId;
   	private Number gameLength;
   	private String gameMode;
   	private String gameType;
   	private Number ipEarned;
   	private MyTeamInfo myTeamInfo;
   	private String myTeamStatus;
   	private OtherTeamInfo otherTeamInfo;
   	private List<?> otherTeamPlayerParticipantStats;
   	private String queueType;
   	private boolean ranked;
   	private String summonerName;
   	private List<?> teamPlayerParticipantStats;

 	public Number getBasePoints(){
		return this.basePoints;
	}
	public void setBasePoints(Number basePoints){
		this.basePoints = basePoints;
	}
 	public Number getElo(){
		return this.elo;
	}
	public void setElo(Number elo){
		this.elo = elo;
	}
 	public Number getEloChange(){
		return this.eloChange;
	}
	public void setEloChange(Number eloChange){
		this.eloChange = eloChange;
	}
 	public Number getGameId(){
		return this.gameId;
	}
	public void setGameId(Number gameId){
		this.gameId = gameId;
	}
 	public Number getGameLength(){
		return this.gameLength;
	}
	public void setGameLength(Number gameLength){
		this.gameLength = gameLength;
	}
 	public String getGameMode(){
		return this.gameMode;
	}
	public void setGameMode(String gameMode){
		this.gameMode = gameMode;
	}
 	public String getGameType(){
		return this.gameType;
	}
	public void setGameType(String gameType){
		this.gameType = gameType;
	}
 	public Number getIpEarned(){
		return this.ipEarned;
	}
	public void setIpEarned(Number ipEarned){
		this.ipEarned = ipEarned;
	}
 	public MyTeamInfo getMyTeamInfo(){
		return this.myTeamInfo;
	}
	public void setMyTeamInfo(MyTeamInfo myTeamInfo){
		this.myTeamInfo = myTeamInfo;
	}
 	public String getMyTeamStatus(){
		return this.myTeamStatus;
	}
	public void setMyTeamStatus(String myTeamStatus){
		this.myTeamStatus = myTeamStatus;
	}
 	public OtherTeamInfo getOtherTeamInfo(){
		return this.otherTeamInfo;
	}
	public void setOtherTeamInfo(OtherTeamInfo otherTeamInfo){
		this.otherTeamInfo = otherTeamInfo;
	}
 	public List<?> getOtherTeamPlayerParticipantStats(){
		return this.otherTeamPlayerParticipantStats;
	}
	public void setOtherTeamPlayerParticipantStats(List<?> otherTeamPlayerParticipantStats){
		this.otherTeamPlayerParticipantStats = otherTeamPlayerParticipantStats;
	}
 	public String getQueueType(){
		return this.queueType;
	}
	public void setQueueType(String queueType){
		this.queueType = queueType;
	}
 	public boolean getRanked(){
		return this.ranked;
	}
	public void setRanked(boolean ranked){
		this.ranked = ranked;
	}
 	public String getSummonerName(){
		return this.summonerName;
	}
	public void setSummonerName(String summonerName){
		this.summonerName = summonerName;
	}
 	public List<?> getTeamPlayerParticipantStats(){
		return this.teamPlayerParticipantStats;
	}
	public void setTeamPlayerParticipantStats(List<?> teamPlayerParticipantStats){
		this.teamPlayerParticipantStats = teamPlayerParticipantStats;
	}
}
