package com.iptech.dreamhousingloan.serviceimpl;

import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;

import com.iptech.dreamhousingloan.exception.InvalidAdharNoException;

//import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.stereotype.Service;

//import com.iptech.dreamhousingloan.exception.InvalidAdharNoException;

import com.iptech.dreamhousingloan.exception.InvalidAgeException;

import com.iptech.dreamhousingloan.exception.InvalidMobileNoException;

import com.iptech.dreamhousingloan.exception.InvalidPancardException;

import com.iptech.dreamhousingloan.exception.invalidEmailException;

import com.iptech.dreamhousingloan.model.Enquiry;
import com.iptech.dreamhousingloan.repository.EnquiryRepository;
import com.iptech.dreamhousingloan.serviceInt.ServiceEnquiryInt;

@Service
public class ServiceEnquiryImpl implements ServiceEnquiryInt {

	// @Autowired private JavaMailSender sender;

	// @Value("${spring.mail.username}") private static String FORM_MAIL;

	@Autowired
	EnquiryRepository er;

	// @Autowired private JavaMailSender sender;

	// @Value("${spring.mail.username}") private static String FORM_MAIL;

	@Override
	public Enquiry saveEnquiry(Enquiry e) {

		// Adhar number exception
		String adharNo = String.valueOf(e.getAdharNo());
		if (adharNo.length() == 12) {

			System.out.println("valid adhar card no");
		} else {
			throw new InvalidAdharNoException("InvalidAdharNoException :" + adharNo);
		}

		// First n last name convert lower to upper case
		if (e.getFirst_Name() != e.getFirst_Name().toUpperCase()) {
			String name = e.getFirst_Name().toUpperCase();

			e.setFirst_Name(name);
		} else {
			e.setFirst_Name(e.getFirst_Name());
		}
		if (e.getLast_Name() != e.getLast_Name().toUpperCase()) {
			String lname = e.getLast_Name().toUpperCase();
			e.setLast_Name(lname);
		} else {
			e.setLast_Name(e.getLast_Name());
		}

		// Gmail exception
		String email = e.getEmail();
		if (e.getEmail().endsWith("@gmail.com")) {

			System.out.println("gmail is correct");
		} else {
			throw new invalidEmailException("invalidEmailException " + email);
		}

		// Age validation
		if (e.getAge() < 18 || e.getAge() > 60) {
			throw new InvalidAgeException("Invalid age: " + e.getAge() + ". Age is Invalid");
		} else {
			System.out.println("Age is valid");
		}

		// Mobile no exception
		String mobileNo = String.valueOf(e.getMobileNo());
		if (mobileNo.length() == 10) {
			System.out.println("valid no" + mobileNo);
		} else {
			throw new InvalidMobileNoException("invalidMobileNoException  " + mobileNo);
		}

		// PanCard exception
		String pancardNo = e.getPancardNo();
		if (pancardNo.length() == 10) {
			Pattern pattern = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]");
			Matcher matcher = pattern.matcher(pancardNo);
			if (matcher.matches())
				System.out.println("valid pancard");
			else
				throw new InvalidPancardException("InvalidPancardException" + pancardNo);
		} else {

			throw new InvalidPancardException("InvalidPancardException  " + pancardNo);
		}
		return er.save(e);

	}

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

		/*
		 * @Override public String sendMail(String toEmail) {
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

	// SimpleMailMessage simple= new SimpleMailMessage();

	// simple.setTo(toEmail); simple.setFrom(FORM_MAIL);
//	  simple.setSubject("Dream housing loan process");
//	  simple.setText("****Your housing loan is sanctioned successfully****");
//	  
//	  sender.send(simple); 
//	  
//	  return "mail send successfully"; 
//	 
}