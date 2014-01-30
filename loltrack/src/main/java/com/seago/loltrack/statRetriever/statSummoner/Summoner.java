
package com.seago.loltrack.statRetriever.statSummoner;

import com.seago.loltrack.statRetriever.Resource;


public class Summoner extends Resource {
   	private Data data;

 	public Data getData(){
		return this.data;
	}
	public void setData(Data data){
		this.data = data;
	}
}
