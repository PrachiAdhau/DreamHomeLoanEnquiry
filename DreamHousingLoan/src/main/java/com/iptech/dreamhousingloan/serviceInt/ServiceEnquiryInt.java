package com.iptech.dreamhousingloan.serviceInt;

import java.util.List;

import com.iptech.dreamhousingloan.model.Enquiry;

public interface ServiceEnquiryInt {

	public Enquiry saveEnquiry(Enquiry e);

	public Enquiry getSingleDataMethod(int id);

	public List<Enquiry> getAllData();


	//public Enquiry updateData(int applicant_Id);

	public Enquiry editEnquiry(Enquiry e);

	
	



}
