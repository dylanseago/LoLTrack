
package com.seago.loltrack.statRetriever.statTeam;

import java.util.List;

public class Roster{
   	private List<?> memberList;
   	private Number ownerId;

 	public List<?> getMemberList(){
		return this.memberList;
	}
	public void setMemberList(List<?> memberList){
		this.memberList = memberList;
	}
 	public Number getOwnerId(){
		return this.ownerId;
	}
	public void setOwnerId(Number ownerId){
		this.ownerId = ownerId;
	}
}
