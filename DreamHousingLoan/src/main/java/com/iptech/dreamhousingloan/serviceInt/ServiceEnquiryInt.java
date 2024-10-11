package com.iptech.dreamhousingloan.serviceInt;

import java.util.List;

import com.iptech.dreamhousingloan.model.Enquiry;

public interface ServiceEnquiryInt {

	public Enquiry saveEnquiry(Enquiry e);

<<<<<<< HEAD
	public void deleteSingle(int applicant_Id);
=======

public void deleteSingle(int applicant_Id);
>>>>>>> branch 'master' of https://github.com/PrachiAdhau/DreamHomeLoanEnquiry.git

	public Enquiry getSingleDataMethod(int id);

	public List<Enquiry> getAllData();

	public void editEnquiry(Enquiry e, int applicant_Id);

<<<<<<< HEAD
	public Enquiry editEnquiry(Enquiry e);
=======
	
	//public String sendMail(String toEmail);


>>>>>>> branch 'master' of https://github.com/PrachiAdhau/DreamHomeLoanEnquiry.git

}
