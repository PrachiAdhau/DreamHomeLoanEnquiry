package com.iptech.dreamhousingloan.serviceInt;

import java.util.List;

import com.iptech.dreamhousingloan.model.Enquiry;

public interface ServiceEnquiryInt {

	public Enquiry saveEnquiry(Enquiry e);


	//public Enquiry deleteSingle(int applicant_Id);

	public List<Enquiry> getAllData();

	

}
