package com.iptech.dreamhousingloan.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cibil {

	@Id
	private int cibil_Id;
	private int cibilScore;
	private String cibilScoreDateandTime;
	private String status;
	private String cibilRemark;
	
}


