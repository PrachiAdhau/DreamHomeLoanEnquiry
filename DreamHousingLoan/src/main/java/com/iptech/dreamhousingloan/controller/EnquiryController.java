package com.iptech.dreamhousingloan.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;






import org.springframework.web.bind.annotation.PostMapping;


import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.iptech.dreamhousingloan.model.Enquiry;
import com.iptech.dreamhousingloan.serviceInt.ServiceEnquiryInt;
import org.springframework.web.bind.annotation.PutMapping;


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
	
	@PutMapping("/edit")
	public ResponseEntity<Enquiry> updateData(@RequestBody Enquiry e)
     {
    	Enquiry en=sei.editEnquiry(e);
	    return new ResponseEntity<Enquiry>(en,HttpStatus.CREATED);
	}
	
@GetMapping("/getsingledata/{id}")
public  ResponseEntity<Enquiry> getSingleDataMethod(@PathVariable ("id") int id)
{ Enquiry e =  sei.getSingleDataMethod(id);
	return new ResponseEntity<Enquiry> (e,HttpStatus.OK);}


	@GetMapping("/getAllData")
	public ResponseEntity<List<Enquiry>> getAllData()
	{
		List<Enquiry> list = sei.getAllData();
		return new ResponseEntity<List<Enquiry>>(list,HttpStatus.OK);
	
}
//@PutMapping("/updatedata/{applicant_Id}")
//public ResponseEntity<Enquiry> updatedata(@PathVariable ("applicant_Id") int  applicant_Id)
//{
//Enquiry update=sei.updateData(applicant_Id);
//return new ResponseEntity<Enquiry>(update, HttpStatus.OK);
}


	
	
	
	
	






