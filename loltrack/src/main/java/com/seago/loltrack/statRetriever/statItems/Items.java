
package com.seago.loltrack.statRetriever.statItems;

import java.util.List;

import com.seago.loltrack.statRetriever.Resource;

public class Items extends Resource {
   	private List<?> data;

 	public List<?> getData(){
		return this.data;
	}
	public void setData(List<?> data){
		this.data = data;
	}
}
