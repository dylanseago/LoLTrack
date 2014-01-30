
package com.seago.loltrack.statRetriever.statRanked_stats;

import com.seago.loltrack.statRetriever.Resource;


public class Ranked_stats extends Resource {
   	private Data data;

 	public Data getData(){
		return this.data;
	}
	public void setData(Data data){
		this.data = data;
	}
}
