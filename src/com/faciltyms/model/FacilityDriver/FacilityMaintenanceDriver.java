package com.faciltyms.model.FacilityDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.faciltyms.model.BussinessUnit.BussinessUnit;
import com.faciltyms.model.Maintenance.Maintenance;
import com.faciltyms.model.Maintenance.MaintenanceOrder;
import com.faciltyms.model.Maintenance.MaintenanceRequest;

public class FacilityMaintenanceDriver {
	private Connection conn = ConnectDatabase.connect();
	FacilityMaintenanceDriver() {
		
	}
	public Maintenance addMaintenanceRequest(BussinessUnit business_unit,Maintenance facilityMaintenance, MaintenanceRequest request) {
		try {
			Statement stmt = conn.createStatement();
			int business_unit_id = business_unit.getBussiunitid();
			int maintenance_id = 0;
			// Request for the business unit maintenance for the business unit table
			// Initially the maintenance status of the business is pending which means it still can be used and default status to the maintenance is 0
			String sql = "Insert into MAINTENANCE (BUSINESS_UNIT_ID,COST,START_DATE,END_DATE,NOTE) " + "values (" + business_unit_id + "," + facilityMaintenance.getCost() + "," + facilityMaintenance.getStartdate() + "," + facilityMaintenance.getEnddate() + "," + facilityMaintenance.getNote()  + ");";
			stmt.execute(sql);
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs!=null && rs.next()) {
				maintenance_id = (int) rs.getLong(1);
			}
			// Adding an initial maintenance request, inserts to MAINTENANCE and MAINTENANCE_REQUEST table.
			sql = "Insert into MAINTENANCE_REQUEST (MAINTENANCE_ID,BUSINESS_UNIT_ID,REQUEST_NOTE,REQUEST_DATE) "
					+ "values (" + maintenance_id + "," + business_unit.getBussiunitid() + "," + request.getNote() + "," + request.getReqdate() + ");";
			stmt.executeQuery(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return facilityMaintenance;
	}
	MaintenanceOrder scheduleMaintenance(BussinessUnit business_unit,Maintenance maintenance, MaintenanceOrder order) {
		try {
			Statement stmt = conn.createStatement();
			int business_unit_id = business_unit.getBussiunitid();
			// Request order is taken in action 
			String sql = "Insert into MAINTENANCE_ORDER (MAINTENANCE_ID,ORDER_DATE,CONTACTS,ORDER_NOTE) " + "values (" + maintenance.getMID() + "," + order.getOrderdate() + "," + order.getContact() + "," + order.getNote()  + ");";
			stmt.execute(sql);
			stmt.getGeneratedKeys();

			// update the maintenance status to 1
			sql = "update MAINTENANCE set STATUS=1 where MAINTENANCE_ID=" + maintenance.getMID() + ";";
			stmt.executeQuery(sql);
			
			//update BUSINESS_UNIT table status set to 0 which means its under construction
			sql = "update BUSINESS_UNIT set STATUS=0 where BUSINESS_UNIT_ID=" + business_unit_id + ";";
			stmt.executeQuery(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}
	
	void maintenanceCompleted(BussinessUnit business_unit,Maintenance maintenance, MaintenanceOrder order) {
		try {
			Statement stmt = conn.createStatement();
			int business_unit_id = business_unit.getBussiunitid();
			//Update maintenance table with cost, status
			String sql = "update MAINTENANCE set STATUS=0,COST="+ maintenance.getCost() + " where MAINTENANCE_ID=" + maintenance.getMID() + ";";
			stmt.executeQuery(sql);
			
			//update the business unit status to be active.
			sql = "update BUSINESS_UNIT set STATUS=1 where BUSINESS_UNIT_ID=" + business_unit_id + ";";
			stmt.executeQuery(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void listAllBusinessUniteUnderMaintenance() {
		try {
			Statement stmt = conn.createStatement();
			@SuppressWarnings("unused")
			List<HashMap<String, String>> business_unit_under_maintenance = (List<HashMap<String, String>>) new ArrayList<HashMap<String, String>>();
			String sql = "select b.*,d.*,m.* from BUSINESS_UNIT as b join BUSINESS_UNIT_DETAILS as d on b.BUSINESS_UNIT_ID=d.BUSINESS_UNIT_ID join MAINTENANCE as m on b.BUSINESS_UNIT_ID=m.BUSINESS_UNIT_ID where STATUS=1;";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs!=null && rs.next()) {
				//((HashMap<String, String>) business_unit_under_maintenance).put("BUSINESS_UNIT_ID",Integer.toString(rs.getInt("BUSINESS_UNIT_ID")));
				//dump business unit that are under construction
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	List<HashMap<String, String>> listMaintenance() {
		List<HashMap<String, String>> lstMaintenance = (List<HashMap<String, String>>) new ArrayList<HashMap<String, String>>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from MAINTENANCE_REQUEST";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs!=null && rs.next()) {
				//((HashMap<String, String>) lstMaintenance).put("MAINTENANCE_ID",Integer.toString(rs.getInt("MAINTENANCE_ID")));
				//dump all the maintenance requests
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lstMaintenance;
	}
}
