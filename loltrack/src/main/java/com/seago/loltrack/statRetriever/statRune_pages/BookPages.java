
package com.seago.loltrack.statRetriever.statRune_pages;

import java.util.List;

class BookPages{
   	private String createDate;
   	private boolean current;
   	private String name;
   	private Number pageId;
   	private List<?> slotEntries;

 	public String getCreateDate(){
		return this.createDate;
	}
	public void setCreateDate(String createDate){
		this.createDate = createDate;
	}
 	public boolean getCurrent(){
		return this.current;
	}
	public void setCurrent(boolean current){
		this.current = current;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public Number getPageId(){
		return this.pageId;
	}
	public void setPageId(Number pageId){
		this.pageId = pageId;
	}
 	public List<?> getSlotEntries(){
		return this.slotEntries;
	}
	public void setSlotEntries(List<?> slotEntries){
		this.slotEntries = slotEntries;
	}
}
