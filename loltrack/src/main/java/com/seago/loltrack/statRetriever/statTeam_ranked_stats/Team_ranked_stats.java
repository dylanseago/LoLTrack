
package com.seago.loltrack.statRetriever.statTeam_ranked_stats;

import java.util.List;

import com.seago.loltrack.statRetriever.Resource;

class Team_ranked_stats extends Resource {
   	private List<?> data;

 	public List<?> getData(){
		return this.data;
	}
	public void setData(List<?> data){
		this.data = data;
	}
}
