package com.iptech.dreamhousingloan.serviceimpl;

import java.util.List;
import java.util.Optional;

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
//	@Autowired
//	private JavaMailSender sender;
//	
//	@Value("${spring.mail.username}")
//    private static String FORM_MAIL;
	

	
	@Override
	public Enquiry saveEnquiry(Enquiry e) {
//		String mobileno= stu.getMobileno();
//		if(mobileno.length()==10)
//		{
//			System.out.println("valid mobile no");
//		}
//		else {
//			throw new InvalidMobileNo("InvalidMobileNo :"+mobileno);
//		}
		Enquiry save=er.save(e);
		return save;
	}


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
	
//	@Override
//	public String sendMail(String toEmail) {
//		
//        SimpleMailMessage simple= new SimpleMailMessage();
//		
//		simple.setTo(toEmail);
//		simple.setFrom(FORM_MAIL);
//		simple.setSubject("Dream housing loan process");
//		simple.setText("****Your housing loan is sanctioned successfully****");
//		
//		sender.send(simple);
//		return "mail send successfully";
//	}
}
