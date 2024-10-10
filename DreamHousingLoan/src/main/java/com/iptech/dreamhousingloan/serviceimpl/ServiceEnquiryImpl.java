package com.iptech.dreamhousingloan.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
	public List<Enquiry> getAllData() {
		
		return er.findAll();
	}


}
