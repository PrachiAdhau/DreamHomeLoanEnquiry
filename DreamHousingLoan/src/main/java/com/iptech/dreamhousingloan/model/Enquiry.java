package com.iptech.dreamhousingloan.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
@Entity
@Data
public class Enquiry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int applicant_Id;
	private String first_Name;
	private String last_Name;
	private int age;
	private String email;
	private long mobileNo;
	private long alternateMobileNo;
	private String pancardNo;
	private long adharNo;
	private String address;
	private String city;
	
	@OneToOne(cascade = CascadeType.ALL)
	private  Cibil cibilScore;
	
	

}
