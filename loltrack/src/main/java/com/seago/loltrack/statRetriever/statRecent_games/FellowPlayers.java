
package com.seago.loltrack.statRetriever.statRecent_games;


class FellowPlayers{
   	private Number championId;
   	private Number summonerId;
   	private String summonerName;
   	private Number teamId;

 	public Number getChampionId(){
		return this.championId;
	}
	public void setChampionId(Number championId){
		this.championId = championId;
	}
 	public Number getSummonerId(){
		return this.summonerId;
	}
	public void setSummonerId(Number summonerId){
		this.summonerId = summonerId;
	}
 	public String getSummonerName(){
		return this.summonerName;
	}
	public void setSummonerName(String summonerName){
		this.summonerName = summonerName;
	}
 	public Number getTeamId(){
		return this.teamId;
	}
	public void setTeamId(Number teamId){
		this.teamId = teamId;
	}
}
