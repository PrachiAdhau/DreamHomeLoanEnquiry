package com.iptech.dreamhousingloan.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iptech.dreamhousingloan.model.Enquiry;
import com.iptech.dreamhousingloan.serviceInt.ServiceEnquiryInt;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {
	
	@Autowired
	ServiceEnquiryInt sei;
	// post method add
	@PostMapping("/save")
	public ResponseEntity<Enquiry> addData(@RequestBody Enquiry e)
	{
		Enquiry en=sei.saveEnquiry(e); 
		return new ResponseEntity<Enquiry>(en, HttpStatus.CREATED);
	}
	


}
