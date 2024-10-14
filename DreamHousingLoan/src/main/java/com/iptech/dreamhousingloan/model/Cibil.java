package com.iptech.dreamhousingloan.model;

import java.util.Date;

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
	private String cibilId;
	private int cibilScore;
	private Date cibilScoreDateandTime;
	private String status;
	private String remark;
	
}


