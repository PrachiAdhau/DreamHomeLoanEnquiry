package com.iptech.dreamhousingloan.serviceInt;

import java.util.List;

import com.iptech.dreamhousingloan.model.Enquiry;

public interface ServiceEnquiryInt {

	public Enquiry saveEnquiry(Enquiry e);


public void deleteSingle(int applicant_Id);

	public Enquiry getSingleDataMethod(int id);

	public List<Enquiry> getAllData();

	public Enquiry editEnquiry(Enquiry e);

	
	
//	public String sendMail(String toEmail);



}
