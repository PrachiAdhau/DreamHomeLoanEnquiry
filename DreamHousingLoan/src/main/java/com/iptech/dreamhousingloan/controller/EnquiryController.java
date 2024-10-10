package com.iptech.dreamhousingloan.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	@DeleteMapping("/del/{applicant_Id}")
	public ResponseEntity<Enquiry> deleteSingleData(@PathVariable int applicant_Id){
		
		Enquiry enq=sei.deleteSingle(applicant_Id);
		return new ResponseEntity<Enquiry>(enq,HttpStatus.OK) ;
		
	}


}
