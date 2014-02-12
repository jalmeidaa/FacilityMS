package com.faciltyms.model.Facility;

public class FacilityDetails {
	 private int facidetail_id;
	 
	 private int facility_id;
	 
	 private String description;
	 
	 private String note;
	 
	 public FacilityDetails(){
		 
	 }
	 public int getFacidetailid(){
		 return facidetail_id;
	 }
	 public void setFacidetailid(int facidetail_id){
		 this.facidetail_id = facidetail_id;
	 }
	 public int getFacilityId(){
		 return facility_id;
	 }
	 public void setFacilityid(int facility_id){
		 this.facility_id = facility_id;
	 }
	 public String getDescription() {
		    return description;
		}
	
	public void setDescription(String description) {
		    this.description = description;
		}
	public String getNote() {
	    return note;
	}
	
	public void setNote(String note) {
	    this.note = note;
	}
}
