package com.iptech.dreamhousingloan.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.iptech.dreamhousingloan.exception.InvalidAdharNoException;
import com.iptech.dreamhousingloan.exception.InvalidMobileNoException;
import com.iptech.dreamhousingloan.exception.invalidEmailException;


@RestControllerAdvice
public class GlobalExceptionHandlerController {
	
	@ExceptionHandler(InvalidAdharNoException.class)
	public ResponseEntity<String> invalidAdharNoException(InvalidAdharNoException ian)
	{
		String msg1=ian.getMessage();
		
		return new ResponseEntity<String>(msg1,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(invalidEmailException.class)
	public ResponseEntity<String>handelinvalidGmailException(invalidEmailException inm)
	{
		String msg=inm.getMessage();
		return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
	}
	
		@ExceptionHandler(InvalidMobileNoException.class)
		public ResponseEntity<String>handelinvalidMobileNo(InvalidMobileNoException inm)
		{
			String msg=inm.getMessage();
			return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
		}
	}


