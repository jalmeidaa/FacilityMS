package com.faciltyms.model.FacilityDriver;
import java.util.HashMap;
import java.util.List;

import com.faciltyms.model.Facility.*;
import com.faciltyms.model.BussinessUnit.BussinessUnit;
import com.faciltyms.model.BussinessUnit.BussinessUnitDetails;

public interface IFacility {
	Facility addFacility(Facility facility, FacilityDetails facility_details, BussinessUnit business_unit, BussinessUnitDetails business_unit_details);
	Facility updateFacility(Facility facility);
	Facility updateFacilityDetails(Facility facility, FacilityDetails facility_details);
	Facility updateBusinessUnit(Facility facility,BussinessUnit business_unit);
	BussinessUnit updateBusinessUnitDetails(BussinessUnit business_unit,BussinessUnitDetails business_unit_details);
	Facility deleteFacility(Facility facility, FacilityDetails facility_details, BussinessUnit business_unit, BussinessUnitDetails business_unit_details);
	List<HashMap<String, String>> getFacilityInfo(int facility_id);
	List<HashMap<String, String>> getAllFacilities();
	List<HashMap<String, String>> getAllVacantReadyFacilities();
}
