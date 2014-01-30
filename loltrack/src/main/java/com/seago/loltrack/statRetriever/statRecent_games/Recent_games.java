
package com.seago.loltrack.statRetriever.statRecent_games;

import com.seago.loltrack.statRetriever.Resource;


public class Recent_games extends Resource {
   	private Data data;

 	public Data getData(){
		return this.data;
	}
	public void setData(Data data){
		this.data = data;
	}
}
