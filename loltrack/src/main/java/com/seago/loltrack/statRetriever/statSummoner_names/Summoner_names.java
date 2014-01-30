
package com.seago.loltrack.statRetriever.statSummoner_names;

import java.util.List;

import com.seago.loltrack.statRetriever.Resource;

class Summoner_names extends Resource {
   	private List<?> data;

 	public List<?> getData(){
		return this.data;
	}
	public void setData(List<?> data){
		this.data = data;
	}
}
