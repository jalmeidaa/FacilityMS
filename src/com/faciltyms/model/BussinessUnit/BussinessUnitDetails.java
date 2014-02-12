package com.faciltyms.model.BussinessUnit;

public class BussinessUnitDetails {
	private int bussiunitdetails_id;
	
	private int bussiunit_id;
	
	private String description;
	
	private String features;
	
	public BussinessUnitDetails(){
		
	}
	public int getBussiunitdetailsid(){
		return bussiunitdetails_id;
	}
	public void setBussiunidetailstid(int bussiunitdetails_id){
		this.bussiunitdetails_id = bussiunitdetails_id;
	}
	public int getBussiunitid(){
		return bussiunit_id;
	}
	public void setBussiunitid(int bussiunit_id){
		this.bussiunit_id = bussiunit_id;
	}
	public String getFeatures(){
		return features;
	}
	public void setFeatures(String features){
		this.features = features;
	}
	public String getDescription(){
		return description;
	}
	public void setDescription(String description){
		this.description = description;
	}
}

