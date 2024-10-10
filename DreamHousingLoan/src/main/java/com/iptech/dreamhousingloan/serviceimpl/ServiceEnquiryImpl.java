package com.iptech.dreamhousingloan.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iptech.dreamhousingloan.model.Enquiry;
import com.iptech.dreamhousingloan.repository.EnquiryRepository;
import com.iptech.dreamhousingloan.serviceInt.ServiceEnquiryInt;
@Service
public class ServiceEnquiryImpl implements ServiceEnquiryInt{

	@Autowired
	EnquiryRepository er;
	
	
	@Override
	public Enquiry saveEnquiry(Enquiry e) {
		Enquiry save=er.save(e);
		return save;
	}


	@Override
	public Enquiry deleteSingle(int applicant_Id) {
		Enquiry enq=er.deleteByApplicant_Id(applicant_Id);
		return enq;
	}

}
