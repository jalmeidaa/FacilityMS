package com.faciltyms.model.FacilityDriver;
import com.faciltyms.model.Facility.*;
import com.faciltyms.model.BussinessUnit.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FacilityDriver implements IFacility {
	private Connection conn = ConnectDatabase.connect();
	public FacilityDriver() {
		
	}
	public Facility addFacility(Facility facility, FacilityDetails facility_details, BussinessUnit business_unit, BussinessUnitDetails business_unit_details) {
		try {
			Statement stmt = conn.createStatement();
			int facility_id = 0;
			int business_unit_id = 0;
			// Adding to Facility table
			String sql = "Insert into FACILITY (NAME,ADDRESS,CONTACT,BUILD_DATE) values (" + facility.getName() + "," + facility.getAddress() + "," + facility.getContact() + "," + facility.getDate()  + ");";
			stmt.execute(sql);
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs!=null && rs.next()) {
				facility_id = (int) rs.getLong(1);
			}
			// Adding to Facility_DETAILS table with FACILITY_ID from FACILITY table
			sql = "Insert into FACILITY_DETAILS (FACILITY_ID,DESCRIPTION,NOTE) values (" + facility_id + "," + facility_details.getDescription() + "," + facility_details.getNote() + ");";
			stmt.executeQuery(sql);
			
			// Adding to BUSINESS_UNIT table
			sql = "Insert int BUSINESS_UNIT (FACILITY_ID, NAME, IS_AVAILABLE, STATUS) values (" + facility_id + "," + business_unit.getName() + "," + business_unit.getAvailability() + "," + business_unit.getStatus() + ");";
			stmt.execute(sql);
			rs = stmt.getGeneratedKeys();
			if (rs!=null && rs.next()) {
				business_unit_id = (int) rs.getLong(1);
			}
			// Adding to BUSINESS_UNIT_DETAILS table
			sql = "Insert int BUSINESS_UNIT_DETAILS (BUSINESS_UNIT_ID,DESCRIPTION,FEATURES) values (" + business_unit_id +","+ business_unit_details.getDescription() + "," + business_unit_details.getFeatures() + ");";
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return facility;
	}
	public Facility updateFacility(Facility facility) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "Update FACILITY set NAME=" + facility.getName() +  
											",ADDRESS=" + facility.getAddress() +
											",CONTACT=" + facility.getContact() +
											",BUILD_DATE=" + facility.getDate() +
											"where FACILITY_ID=" + facility.getID() + ";";
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return facility;
	}
	public Facility updateFacilityDetails(Facility facility, FacilityDetails facility_details) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "Update FACILITY_DETAILS set FACILITY_ID=" + facility.getName() +  
											",DESCRIPTION=" + facility.getAddress() +
											",NOTE=" + facility.getContact() +
											"where FACILITY_ID=" + facility.getID() + ";";
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return facility;
	}
	public Facility updateBusinessUnit(Facility facility,BussinessUnit business_unit) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "Update BUSINESS_UNIT set FACILITY_ID=" + facility.getName() +  
											",NAME=" + facility.getAddress() +
											",IS_AVAILABLE=" + business_unit.getAvailability() +
											",STATUS=" + business_unit.getStatus() + 
											" where FACILITY_ID=" + facility.getID() + " and BUSINESS_UNIT_ID=" + business_unit.getFacilityid() +";";
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return facility;
	}
	public BussinessUnit updateBusinessUnitDetails(BussinessUnit business_unit,BussinessUnitDetails business_unit_details) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "Update BUSINESS_UNIT_DETAILS set DESCRIPTION=" + business_unit_details.getDescription() +  
											",FEATURES=" + business_unit_details.getFeatures() +
											" where BUSINESS_UNIT_DETAILS_ID=" + business_unit_details.getBussiunitdetailsid() + " and BUSINESS_UNIT_ID=" + business_unit.getBussiunitid() +";";
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return business_unit;
	}

	public Facility deleteFacility(Facility facility, FacilityDetails facility_details, BussinessUnit business_unit, BussinessUnitDetails business_unit_details) {
		try {
			Statement stmt = conn.createStatement();
			// Delete from Facility table
			String sql = "Delete from FACILITY where FACILITY_ID=" + facility.getID() + ";";
			stmt.execute(sql);

			// Delete from Facility_DETAILS table with FACILITY_ID from FACILITY table
			sql = "Delete from FACILITY_DETAILS where FACILITY_ID=" + facility.getID() + " and FACILITY_DETAILS_ID=" + facility_details.getFacidetailid() + ";";
			stmt.executeQuery(sql);
			
			// Delete from BUSINESS_UNIT table
			sql = "Delete from BUSINESS_UNIT where FACILITY_ID=" + facility.getID() + " and BUSINESS_UNIT_ID=" + business_unit.getBussiunitid() + ";";
			stmt.execute(sql);

			// Delete from BUSINESS_UNIT_DETAILS table
			sql = "Delete from BUSINESS_UNIT_DETAILS where BUSINESS_UNIT_DETAILS_ID=" + business_unit_details.getBussiunitdetailsid() + " and BUSINESS_UNIT_ID=" + business_unit.getBussiunitid() + ";";
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return facility;
	}
	
	public List<HashMap<String, String>> getFacilityInfo(int facility_id) {
		List<HashMap<String, String>> facilityInfo = (List<HashMap<String, String>>) new ArrayList<HashMap<String, String>>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT f.*,d.* FROM FACILITY as f join FACILITY_DETAILS as d on f.FACILITY_ID=d.FACILITY_ID where FACILITY_ID=" + facility_id + ";";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next())
			{
				//((HashMap<String, String>) facilityInfo).put("FACILITY_ID",Integer.toString(rs.getInt("FACILITY_ID")));
				//dump facility and facility details
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return facilityInfo; // returns Facility and Facility Details rows
	}
	@SuppressWarnings("unchecked")
	public List<HashMap<String, String>> getBusinessUnitInfo(int facility_id, int business_unit_id) {
		List<HashMap<String, String>> business_unit_info = (List<HashMap<String, String>>) new ArrayList<HashMap<String, String>>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT b.*,d.* FROM BUSINESS_UNIT as b join BUSINESS_UNIT_DETAILS as d on b.BUSINESS_UNIT_ID=d.BUSINESS_UNIT_ID where FACILITY_ID=" + facility_id + " and b.BUSINESS_UNIT_ID=" + business_unit_id +";";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next())
			{
				((HashMap<String, String>) business_unit_info).put("FACILITY_ID",Integer.toString(rs.getInt("FACILITY_ID")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return business_unit_info; // returns Facility and Facility Details rows
	}
	//This function pull all the facilities regardless of the unit status
	@SuppressWarnings("unchecked")
	public List<HashMap<String, String>> getAllFacilities() {
		List<HashMap<String, String>> facilities_list = (List<HashMap<String, String>>) new ArrayList<HashMap<String, String>>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "Select a.*,d.*,b.*,u.* from FACILITY as f join FACILITY_DETAILS as d on "
					+ "a.FACILITY_ID=d.FACILITY_ID join BUSINESS_UNIT as b on a.FACILITY_ID=b.FACILITY_ID join BUSINESS_UNIT_DETAILS;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				((HashMap<String, String>) facilities_list).put("FACILITY_ID",Integer.toString(rs.getInt("FACILITY_ID")));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return facilities_list;
	}
	//This function return all the vacant business units
	public List<HashMap<String, String>> getAllVacantReadyFacilities() {
		List<HashMap<String, String>> vacant_ready_facilities_list = (List<HashMap<String, String>>) new ArrayList<HashMap<String, String>>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "Select a.*,d.*,b.*,u.* from FACILITY as f join FACILITY_DETAILS as d on "
					+ "a.FACILITY_ID=d.FACILITY_ID join BUSINESS_UNIT as b on a.FACILITY_ID=b.FACILITY_ID join BUSINESS_UNIT_DETAILS" + " where b.STATUS=1 and b.IS_AVAILABLE=1;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				//((HashMap<String, String>) vacant_ready_facilities_list).put("FACILITY_ID",Integer.toString(rs.getInt("FACILITY_ID")));
				//dump to display all vacant business unit which are not under constructions
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vacant_ready_facilities_list;
	}
	
	//This function return all the vacant business units
	public List<HashMap<String, String>> getAllBusinessUnitUnderConstruction() {
		List<HashMap<String, String>> vacant_ready_facilities_list = (List<HashMap<String, String>>) new ArrayList<HashMap<String, String>>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "Select a.*,d.*,b.*,u.* from FACILITY as f join FACILITY_DETAILS as d on "
					+ "a.FACILITY_ID=d.FACILITY_ID join BUSINESS_UNIT as b on a.FACILITY_ID=b.FACILITY_ID join BUSINESS_UNIT_DETAILS" + " where b.IS_AVAILABLE=0;";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				//((HashMap<String, String>) vacant_ready_facilities_list).put("FACILITY_ID",Integer.toString(rs.getInt("FACILITY_ID")));
				//dump it to display
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vacant_ready_facilities_list;
	}
	
	
}
