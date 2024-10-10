package com.iptech.dreamhousingloan.serviceInt;

import java.util.List;

import com.iptech.dreamhousingloan.model.Enquiry;

public interface ServiceEnquiryInt {

	public Enquiry saveEnquiry(Enquiry e);


	public List<Enquiry> getAllData();

	public Enquiry editEnquiry(Enquiry e);

	Enquiry getSingleDataMethod(int id);
	
//	public String sendMail(String toEmail);


}
