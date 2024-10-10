package com.iptech.dreamhousingloan.serviceimpl;

import java.util.List;


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

	public void deleteSingle(int applicant_Id) {
		er.deleteById(applicant_Id);
		
	}


	@Override



	public Enquiry getSingleDataMethod(int id) {
		Enquiry e= er.findById(id).get();
		return e;}


	public List<Enquiry> getAllData() {
		
		return er.findAll();

	}





	@Override
	public Enquiry editEnquiry(Enquiry e) {
		Enquiry save=er.save(e);
		return save;
	}



	@Override
	public Enquiry updatedata(int applicant_Id) {
		Enquiry update=er.updateById(applicant_Id);
		return update;
	}


	


}
