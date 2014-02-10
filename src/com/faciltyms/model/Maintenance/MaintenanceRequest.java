package com.faciltyms.model.Maintenance;

import java.util.Date;

public class MaintenanceRequest {
	private int id;

	private int m_id;

    private int b_id;

	private String note;

	private Date reqdate;

	
	public MaintenanceRequest() {

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
    public int getBID() {
        return b_id;
    }

    public void setBID(int b_id) {
        this.b_id = b_id;
    }

    public Date getReqdate() {
        return reqdate;
    }

    public void setReqdate(Date reqdate) {
        this.reqdate = reqdate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
