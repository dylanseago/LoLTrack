
package com.seago.loltrack.statRetriever.statRecent_games;

import java.util.List;

public class Data{
   	private List<?> gameStatistics;
   	private Number userId;

 	public List<?> getGameStatistics(){
		return this.gameStatistics;
	}
	public void setGameStatistics(List<?> gameStatistics){
		this.gameStatistics = gameStatistics;
	}
 	public Number getUserId(){
		return this.userId;
	}
	public void setUserId(Number userId){
		this.userId = userId;
	}
}
