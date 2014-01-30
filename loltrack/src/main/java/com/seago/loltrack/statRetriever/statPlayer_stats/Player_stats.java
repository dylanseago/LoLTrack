
package com.seago.loltrack.statRetriever.statPlayer_stats;


public class Player_stats{
   	private Data data;
   	private boolean success;

 	public Data getData(){
		return this.data;
	}
	public void setData(Data data){
		this.data = data;
	}
 	public boolean getSuccess(){
		return this.success;
	}
	public void setSuccess(boolean success){
		this.success = success;
	}
}
