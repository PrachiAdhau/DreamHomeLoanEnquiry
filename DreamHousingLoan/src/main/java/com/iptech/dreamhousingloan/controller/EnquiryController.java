package com.iptech.dreamhousingloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.web.bind.annotation.GetMapping;

//import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.iptech.dreamhousingloan.model.Cibil;
import com.iptech.dreamhousingloan.model.Enquiry;
import com.iptech.dreamhousingloan.serviceInt.ServiceEnquiryInt;

@RestController
@CrossOrigin("*")
@RequestMapping("/enquiry")
public class EnquiryController {
	
	@Autowired
	RestTemplate rt;

	@Autowired
	ServiceEnquiryInt sei;

	// post method add
	@PostMapping("/save")
	public ResponseEntity<Enquiry> addData(@RequestBody Enquiry e) {
		Enquiry en = sei.saveEnquiry(e);
		return new ResponseEntity<Enquiry>(en, HttpStatus.CREATED);
		
	}


	@DeleteMapping("/del/{applicant_Id}")


	public ResponseEntity<String> deleteSingleData(@PathVariable int applicant_Id) {

		sei.deleteSingle(applicant_Id);
		return new ResponseEntity<String>("delete data", HttpStatus.ACCEPTED);

	
	
	}

	@PutMapping("/edit")
	public ResponseEntity<Enquiry> updateData(@RequestBody Enquiry e) {
		Enquiry en = sei.editEnquiry(e);
		return new ResponseEntity<Enquiry>(en, HttpStatus.CREATED);
	}

	@PutMapping("/edit/{applicant_Id}")
	public ResponseEntity<String> updateData(@RequestBody Enquiry e, @PathVariable("applicant_Id") int applicant_Id)

	{
		sei.editEnquiry(e, applicant_Id);
		return new ResponseEntity<String>("Data updated", HttpStatus.CREATED);

	}


	@GetMapping("/getsingledata/{id}")
	public ResponseEntity<Enquiry> getSingleDataMethod(@PathVariable("id") int id) {
		Enquiry e = sei.getSingleDataMethod(id);
		return new ResponseEntity<Enquiry>(e, HttpStatus.OK);
}

	@GetMapping("/getAllData")
	public ResponseEntity<List<Enquiry>> getAllData() {
		List<Enquiry> list = sei.getAllData();
		return new ResponseEntity<List<Enquiry>>(list, HttpStatus.OK);

	}




	/*
	 * @GetMapping("/send/{toEmail}") public ResponseEntity<String>
	 * sendMail(@PathVariable String toEmail) { String s=sei.sendMail(toEmail);
	 * return new ResponseEntity<String>(s,HttpStatus.OK); }
	 */

	public void m1() {
		System.out.println("m1 method");
	}
	
	@GetMapping("/getCibilDetails")
	public ResponseEntity<Cibil> getCibilDetails() {
		String url = "http://localhost:9099/getCibilDetails";
		Cibil cbl = rt.getForObject(url, Cibil.class);
		System.out.println(cbl);
		return new ResponseEntity<Cibil>(cbl, HttpStatus.OK);

	}

	@PutMapping("/getCibilbyeid/{id}")
	public ResponseEntity<Enquiry> getCibilByEid(@PathVariable("id") int id) {
		ResponseEntity<Cibil> cc = getCibilDetails();
		Cibil cibil = cc.getBody();
		
		ResponseEntity<Enquiry> e=getSingleDataMethod(id);
		Enquiry enq=e.getBody();
		enq.setCibilScore(cibil);
		sei.saveEnquiry(enq);

		return new ResponseEntity<Enquiry>(enq,HttpStatus.OK);

	}
	
	@PutMapping("/updateCibilStatus/{applicant_Id}")
	public ResponseEntity<String> updateCibil(@RequestBody Enquiry e, @PathVariable("applicant_Id") int applicant_Id)
		{
		    sei.updateCibil(e);
			return new ResponseEntity<String>("Cibil status updated",HttpStatus.CREATED);
			
		}
	
	@DeleteMapping("/delByAllEnquiry")
	public ResponseEntity<String> deleteByAllEnquiry(){
		sei.deleteAllEnquiry();
		return new ResponseEntity<String>("delete enquiry",HttpStatus.OK);

     }
	
		
		  @GetMapping("/getByCibilStatus/{status}") 
		  public ResponseEntity<List<Enquiry>>  getEnquiriesByCibilStatus(@PathVariable("status") String status) 
		  {
		  List<Enquiry> enquiries = sei.getEnquiriesByCibilStatus(status); 
		  return new  ResponseEntity<List<Enquiry>>(enquiries, HttpStatus.OK);
		  }
		 
	
}


	


	

	






