package com.iptech.dreamhousingloan.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;
import com.iptech.dreamhousingloan.exception.InvalidAdharNoException;

import com.iptech.dreamhousingloan.exception.MobileNumberNotFound;
import com.iptech.dreamhousingloan.model.Enquiry;
import com.iptech.dreamhousingloan.repository.EnquiryRepository;
import com.iptech.dreamhousingloan.serviceInt.ServiceEnquiryInt;


@Service
public class ServiceEnquiryImpl implements ServiceEnquiryInt {

	@Autowired
	EnquiryRepository er;



	  
	 // @Autowired private JavaMailSender sender;
	  
	//  @Value("${spring.mail.username}") private static String FORM_MAIL;
	 

	




	@Override
	public Enquiry saveEnquiry(Enquiry e) {

		
		long num=e.getMobileNo();
		 
		 int count=0;
		 
		do
		{
			num=num/10;
			count++;
			
		}
		while(num!=0) ;
		if(count==10)
		{
	 // return   er.save(e);
			System.out.println("valid mobile  no");
	
	    }
		else 
		{
			 throw new MobileNumberNotFound("particular Enquiry not found:");
		}
			
		

		// Adhar number exception
		String adharNo= String.valueOf(e.getAdharNo());
		if(adharNo.length()==12)
		{
			
			System.out.println("valid adhar card no");
		}
		else {
			throw new InvalidAdharNoException("InvalidAdharNoException :"+adharNo);
		}
		Enquiry save = er.save(e);
		return save;

	}


		
//	}

	@Override

	public void deleteSingle(int applicant_Id) {
		er.deleteById(applicant_Id);

	}

	@Override

	public Enquiry getSingleDataMethod(int id) {
		Enquiry e = er.findById(id).get();
		return e;
	}

	public List<Enquiry> getAllData() {

		return er.findAll();

	}
	@Override

	public Enquiry editEnquiry(Enquiry e) {
		Enquiry save = er.save(e);
		return save;

	}
	public void editEnquiry(Enquiry e, int applicant_Id) {
		Enquiry eq = er.findById(applicant_Id).get();

		if (null != eq) {
			eq.setFirst_Name(e.getFirst_Name());
			eq.setLast_Name(e.getLast_Name());
			eq.setAge(e.getAge());
			eq.setEmail(e.getEmail());
			eq.setMobileNo(e.getMobileNo());
			eq.setAlternateMobileNo(e.getAlternateMobileNo());
			eq.setPancardNo(e.getPancardNo());
			eq.setAdharNo(e.getAdharNo());
			eq.setAddress(e.getAddress());
			eq.setCity(e.getCity());
			eq.setCibilScore(e.getCibilScore());
			er.save(eq);
		} else {
			System.out.println("Data is not present");
		}

	}


	// @Override
	/*
	 * public String sendMail(String toEmail) {
	 * 
	 * SimpleMailMessage simple= new SimpleMailMessage();
	 * 
	 * simple.setTo(toEmail); simple.setFrom(FORM_MAIL);
	 * simple.setSubject("Dream housing loan process");
	 * simple.setText("****Your housing loan is sanctioned successfully****");
	 * 
	 * sender.send(simple); return "mail send successfully"; }
	 */



	

}
