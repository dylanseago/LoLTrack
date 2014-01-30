
package com.seago.loltrack.statRetriever.statFind_team;


class MemberList{
   	private String inviteDate;
   	private String joinDate;
   	private Number playerId;
   	private String playerName;
   	private String status;

 	public String getInviteDate(){
		return this.inviteDate;
	}
	public void setInviteDate(String inviteDate){
		this.inviteDate = inviteDate;
	}
 	public String getJoinDate(){
		return this.joinDate;
	}
	public void setJoinDate(String joinDate){
		this.joinDate = joinDate;
	}
 	public Number getPlayerId(){
		return this.playerId;
	}
	public void setPlayerId(Number playerId){
		this.playerId = playerId;
	}
 	public String getPlayerName(){
		return this.playerName;
	}
	public void setPlayerName(String playerName){
		this.playerName = playerName;
	}
 	public String getStatus(){
		return this.status;
	}
	public void setStatus(String status){
		this.status = status;
	}
}
