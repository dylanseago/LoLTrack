
package com.seago.loltrack.statRetriever.statFind_team;


class TeamStatDetails{
   	private Number averageGamesPlayed;
   	private Number losses;
   	private Number maxRating;
   	private Number rating;
   	private Number seedRating;
   	private String teamStatType;
   	private Number wins;

 	public Number getAverageGamesPlayed(){
		return this.averageGamesPlayed;
	}
	public void setAverageGamesPlayed(Number averageGamesPlayed){
		this.averageGamesPlayed = averageGamesPlayed;
	}
 	public Number getLosses(){
		return this.losses;
	}
	public void setLosses(Number losses){
		this.losses = losses;
	}
 	public Number getMaxRating(){
		return this.maxRating;
	}
	public void setMaxRating(Number maxRating){
		this.maxRating = maxRating;
	}
 	public Number getRating(){
		return this.rating;
	}
	public void setRating(Number rating){
		this.rating = rating;
	}
 	public Number getSeedRating(){
		return this.seedRating;
	}
	public void setSeedRating(Number seedRating){
		this.seedRating = seedRating;
	}
 	public String getTeamStatType(){
		return this.teamStatType;
	}
	public void setTeamStatType(String teamStatType){
		this.teamStatType = teamStatType;
	}
 	public Number getWins(){
		return this.wins;
	}
	public void setWins(Number wins){
		this.wins = wins;
	}
}
