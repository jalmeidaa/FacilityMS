package com.faciltyms.model.Maintenance;

import java.util.Date;

public class MaintenanceOrder {
private int id;

private int m_id;

private Date order_date;

private String contact;

private String note;

public MaintenanceOrder(){
	
}
public int getID() {
    return id;
}

public void setID(int id) {
    this.id = id;
}

public int getMID() {
    return m_id;
}

public void setMID(int m_id) {
    this.m_id = m_id;
}
public Date getOrderdate() {
    return order_date;
}

public void setOrderdate(Date order_date) {
    this.order_date = order_date;
}
public String getContact() {
    return contact;
}

public void setContact(String contact) {
    this.contact = contact;
}
public String getNote() {
    return note;
}

public void setNote(String note) {
    this.note = note;
}
}

