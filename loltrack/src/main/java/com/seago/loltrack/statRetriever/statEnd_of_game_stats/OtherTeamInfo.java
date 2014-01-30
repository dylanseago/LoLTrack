
package com.seago.loltrack.statRetriever.statEnd_of_game_stats;


public class OtherTeamInfo{
   	private String name;
   	private String tag;
   	private TeamId teamId;

 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public String getTag(){
		return this.tag;
	}
	public void setTag(String tag){
		this.tag = tag;
	}
 	public TeamId getTeamId(){
		return this.teamId;
	}
	public void setTeamId(TeamId teamId){
		this.teamId = teamId;
	}
}
