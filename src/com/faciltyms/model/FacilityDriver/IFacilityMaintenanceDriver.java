package com.faciltyms.model.FacilityDriver;

import java.util.HashMap;
import java.util.List;

import com.faciltyms.model.BussinessUnit.BussinessUnit;
import com.faciltyms.model.Maintenance.Maintenance;
import com.faciltyms.model.Maintenance.MaintenanceRequest;
import com.faciltyms.model.Maintenance.MaintenanceOrder;;

public interface IFacilityMaintenanceDriver {
	Maintenance addMaintenanceRequest(BussinessUnit business_unit,Maintenance maintenance, MaintenanceRequest request);
	MaintenanceOrder scheduleMaintenance(BussinessUnit business_unit,Maintenance maintenance, MaintenanceOrder order);
	void maintenanceCompleted(BussinessUnit business_unit,Maintenance maintenance, MaintenanceOrder order);
	void listAllBusinessUniteUnderMaintenance();
	List<HashMap<String, String>> listMaintenanceRequest();

}
