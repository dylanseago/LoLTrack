
package com.seago.loltrack.statRetriever.statTeam;

import com.seago.loltrack.statRetriever.Resource;


class Team extends Resource {
   	private Data data;

 	public Data getData(){
		return this.data;
	}
	public void setData(Data data){
		this.data = data;
	}
}
