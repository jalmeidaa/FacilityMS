package com.faciltyms.model.Facility;

import java.util.Date;

public class FacilityUse {
private int faciuse_id;

private int bussiuse_id;

private int price;

private Date start_date;

private Date end_date;

private String note;

public FacilityUse(){
	
}
public int getFaciuseid(){
	return faciuse_id;
}
public void setFaciuseid(int faciuse_id){
	this.faciuse_id = faciuse_id;
}
public int getBussiuseid(){
	return bussiuse_id;
}
public void setBussiuseid(int bussiuse_id){
	this.bussiuse_id = bussiuse_id;
}
public int getPrice(){
	return price;
}
public void setPrice(int price){
	this.price = price;
}
public Date getStartdate() {
    return start_date;
}

public void setStartdate(Date start_date) {
    this.start_date = start_date;
}
public Date getEnddate() {
    return end_date;
}

public void setEnddate(Date end_date) {
    this.end_date = end_date;
}
public String getNote(){
	return note;
}
public void setNote(String note){
	this.note = note ;
}
}
