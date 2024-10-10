package com.iptech.dreamhousingloan.serviceInt;

import com.iptech.dreamhousingloan.model.Enquiry;

public interface ServiceEnquiryInt {

	public Enquiry saveEnquiry(Enquiry e);

	public Enquiry editEnquiry(int applicant_Id);
	

}
