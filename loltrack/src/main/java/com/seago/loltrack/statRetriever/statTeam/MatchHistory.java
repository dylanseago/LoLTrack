
package com.seago.loltrack.statRetriever.statTeam;


class MatchHistory{
   	private Number assists;
   	private Number date;
   	private Number deaths;
   	private Number gameId;
   	private String gameMode;
   	private boolean invalid;
   	private Number kills;
   	private Number mapId;
   	private Number opposingTeamKills;
   	private String opposingTeamName;
   	private boolean win;

 	public Number getAssists(){
		return this.assists;
	}
	public void setAssists(Number assists){
		this.assists = assists;
	}
 	public Number getDate(){
		return this.date;
	}
	public void setDate(Number date){
		this.date = date;
	}
 	public Number getDeaths(){
		return this.deaths;
	}
	public void setDeaths(Number deaths){
		this.deaths = deaths;
	}
 	public Number getGameId(){
		return this.gameId;
	}
	public void setGameId(Number gameId){
		this.gameId = gameId;
	}
 	public String getGameMode(){
		return this.gameMode;
	}
	public void setGameMode(String gameMode){
		this.gameMode = gameMode;
	}
 	public boolean getInvalid(){
		return this.invalid;
	}
	public void setInvalid(boolean invalid){
		this.invalid = invalid;
	}
 	public Number getKills(){
		return this.kills;
	}
	public void setKills(Number kills){
		this.kills = kills;
	}
 	public Number getMapId(){
		return this.mapId;
	}
	public void setMapId(Number mapId){
		this.mapId = mapId;
	}
 	public Number getOpposingTeamKills(){
		return this.opposingTeamKills;
	}
	public void setOpposingTeamKills(Number opposingTeamKills){
		this.opposingTeamKills = opposingTeamKills;
	}
 	public String getOpposingTeamName(){
		return this.opposingTeamName;
	}
	public void setOpposingTeamName(String opposingTeamName){
		this.opposingTeamName = opposingTeamName;
	}
 	public boolean getWin(){
		return this.win;
	}
	public void setWin(boolean win){
		this.win = win;
	}
}
