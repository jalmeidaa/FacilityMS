package com.faciltyms.model.Maintenance;

import java.util.Date;

public class Maintenance {

private int m_id;

private  int b_id;

private int cost;

private Date start_date;

private Date end_date;

private String status;

private String note;

public Maintenance(){
	
}
public int getMID() {
    return m_id;
}

public void setMID(int m_id) {
    this.m_id = m_id;
}
public int getBID() {
    return b_id;
}

public void setBID(int b_id) {
    this.b_id = b_id;
}
public int getCost() {
    return cost;
}

public void setCost(int cost) {
    this.cost = cost;
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
public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}
public String getNote() {
    return note;
}

public void setNote(String note) {
    this.note = note;
}
}
