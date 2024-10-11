package com.iptech.dreamhousingloan.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.iptech.dreamhousingloan.exception.InvalidAdharNoException;


@RestControllerAdvice
public class GlobalExceptionHandlerController {
	
	@ExceptionHandler(InvalidAdharNoException.class)
	public ResponseEntity<String> invalidAdharNoException(InvalidAdharNoException ian)
	{
		String msg1=ian.getMessage();
		
		return new ResponseEntity<String>(msg1,HttpStatus.BAD_REQUEST);
	}
	


}
