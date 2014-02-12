package com.faciltyms.model.FacilityDriver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.faciltyms.model.Facility.FacilityUse;


public class FacilityUseDriver implements IFacilityUseDriver {
	private Connection conn = ConnectDatabase.connect();
	public FacilityUseDriver() {
		
	}
	// checks for business units which are vacant and ready to rent
	public boolean checkBusinessUnitStatusToRent(int facility_id, int business_unit_id) {
		boolean isReady = false;
		@SuppressWarnings("unused")
		List<HashMap<String, String>> vacant_ready_facilities_list = (List<HashMap<String, String>>) new ArrayList<HashMap<String, String>>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "Select a.*,d.*,b.*,u.* from FACILITY as f join FACILITY_DETAILS as d on "
					+ "a.FACILITY_ID=d.FACILITY_ID join BUSINESS_UNIT as b on a.FACILITY_ID=b.FACILITY_ID join BUSINESS_UNIT_DETAILS" + " where b.STATUS=1 and b.IS_AVAILABLE=1;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				isReady = true;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isReady;
	}
	public List<HashMap<String, String>> getAllAvailableReadyToRentBusinessUnits() {
		List<HashMap<String, String>> vacant_business_unit_ready_to_lease = (List<HashMap<String, String>>) new ArrayList<HashMap<String, String>>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "Select a.*,d.*,b.*,u.* from FACILITY as f join FACILITY_DETAILS as d on "
					+ "a.FACILITY_ID=d.FACILITY_ID join BUSINESS_UNIT as b on a.FACILITY_ID=b.FACILITY_ID join BUSINESS_UNIT_DETAILS" + " where b.STATUS=1 and b.IS_AVAILABLE=1;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				// To Do
				// Display list of all facilities unit that are good for leasing
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vacant_business_unit_ready_to_lease;
	}
	
	public List<HashMap<String, String>> getAllRentedBusinessUnit()
	{
		List<HashMap<String, String>> rented_business_unit = (List<HashMap<String, String>>) new ArrayList<HashMap<String, String>>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "Select a.*,d.*,b.*,u.* from FACILITY as f join FACILITY_DETAILS as d on "
					+ "a.FACILITY_ID=d.FACILITY_ID join BUSINESS_UNIT as b on a.FACILITY_ID=b.FACILITY_ID join BUSINESS_UNIT_DETAILS" + " where b.STATUS=1 and b.IS_AVAILABLE=1;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				// To Do
				// Display all the business unit that are being leased
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rented_business_unit;
	}
	public void leaseBusinessUnit(int facility_id, int business_id, FacilityUse facility_use) {
		try {
			Statement stmt = conn.createStatement();
			//lease the business unit 
			String sql = "Insert into FACILITY_USE (BUSINESS_UNIT_ID,PRICE,START_DATE,END_DATE,NOTE) values (" + business_id + "," + facility_use.getPrice() + "," + facility_use.getStartdate() + "," + facility_use.getEnddate() + ");";
			stmt.executeQuery(sql);
			// update the status of the business to 0 which is on lease
			sql = "Update BUSINESS_UNIT set STATUS=0 where BUSINESS_UNIT_ID=" + business_id + "and FACILITY_ID=" + facility_id + ";";
			stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
