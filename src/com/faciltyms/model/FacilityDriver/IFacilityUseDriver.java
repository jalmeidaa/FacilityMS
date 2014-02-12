package com.faciltyms.model.FacilityDriver;
import java.util.HashMap;
import java.util.List;

import com.faciltyms.model.Facility.FacilityUse;

public interface IFacilityUseDriver {
	boolean checkBusinessUnitStatusToRent(int facility_id, int business_unit_id);
	List<HashMap<String, String>> getAllAvailableReadyToRentBusinessUnits();
	List<HashMap<String, String>> getAllRentedBusinessUnit();
	void leaseBusinessUnit(int facility_id,int business_id,FacilityUse facility_use);
}