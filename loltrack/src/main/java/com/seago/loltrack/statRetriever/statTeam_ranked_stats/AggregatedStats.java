
package com.seago.loltrack.statRetriever.statTeam_ranked_stats;

import java.util.List;

public class AggregatedStats{
   	private List<?> lifetimeStatistics;
   	private String modifyDate;

 	public List<?> getLifetimeStatistics(){
		return this.lifetimeStatistics;
	}
	public void setLifetimeStatistics(List<?> lifetimeStatistics){
		this.lifetimeStatistics = lifetimeStatistics;
	}
 	public String getModifyDate(){
		return this.modifyDate;
	}
	public void setModifyDate(String modifyDate){
		this.modifyDate = modifyDate;
	}
}
