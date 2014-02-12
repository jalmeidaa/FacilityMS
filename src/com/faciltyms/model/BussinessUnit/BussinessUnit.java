package com.faciltyms.model.BussinessUnit;

public class BussinessUnit {
	private int bussiunit_id;
	
	private int facility_id;
	
	private String name;
	
	private int availability;
	
	private int status;
	
	public BussinessUnit(){
		
	}
	public int getBussiunitid() {
	    return bussiunit_id;
	}
	
	public void setBussiunitid(int bussiunit_id) {
	    this.bussiunit_id = bussiunit_id;
	}
	public int getFacilityid() {
	    return facility_id;
	}
	
	public void setFacilityid(int facility_id) {
	    this.facility_id = facility_id;
	}
	public String getName() {
	    return name;
	}
	
	public void setName(String name) {
	    this.name = name;
	}
	public int getAvailability() {
	    return availability;
	}
	
	public void setAvailability(int availability) {
	    this.availability = availability;
	}
	public int getStatus() {
	    return status;
	}
	
	public void setStatus(int status) {
	    this.status = status;
	}
}
