package com.faciltyms.model.Facility;

import java.util.Date;

public class Facility {
	
	private int id;

	private String name;

	private String address;

	private String contact;
	
	private Date build_date;
	
	public Facility() {
		
	}
	public int getID() {
	    return id;
	}
	
	public void setID(int id) {
	    this.id = id;
	}
	public String getName() {
	    return name;
	}
	
	public void setName(String name) {
	    this.name = name;
	}
	public String getAddress() {
	    return address;
	}
	
	public void setAddress(String address) {
	    this.address = address ;
	}
	public String getContact() {
	    return contact;
	}
	
	public void setContact(String contact) {
	    this.contact = contact;
	}
	public Date getDate(){
		return build_date;
	}
	public void setDate(Date build_date){
		this.build_date = build_date;
	}
}
