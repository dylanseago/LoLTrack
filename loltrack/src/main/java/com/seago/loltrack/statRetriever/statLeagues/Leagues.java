
package com.seago.loltrack.statRetriever.statLeagues;

import com.seago.loltrack.statRetriever.Resource;


public class Leagues extends Resource {
   	private Data data;

 	public Data getData(){
		return this.data;
	}
	public void setData(Data data){
		this.data = data;
	}
}
