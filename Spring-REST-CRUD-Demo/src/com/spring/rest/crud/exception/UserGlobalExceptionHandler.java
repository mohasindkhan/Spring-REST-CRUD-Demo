package com.spring.rest.crud.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import com.spring.rest.crud.model.*;


@ControllerAdvice
public class UserGlobalExceptionHandler 
{
	
	// HANDLING EXCEPTION BY @EXCEPTIONHANDLER AGAINST USEREXCEPTION
		@ExceptionHandler
		public ResponseEntity<CustomError> handleException(UserException exc)
		{
			// DEFINING USER EXCEPTION
			CustomError usererr = new CustomError();
			
			// SETTING VALUES FOR EXCEPTION
			usererr.setStatus(HttpStatus.NOT_FOUND.value());
			usererr.setMsg(exc.getMessage());
			usererr.setTimestamp(System.currentTimeMillis());
			
			// RETURNING ERROR RESPONSE WITH GETTER VALUES AND STATUS CODE
			return new ResponseEntity<>(usererr, HttpStatus.NOT_FOUND);
		}
		
		
		// ANOTHER EXCEPTION HANDLER FOR HANDELLING ANY TYPE OF EXCEPTION
		@ExceptionHandler
		public ResponseEntity<CustomError> handleException(Exception exc)
		{
			// DEFINING USER EXCEPTION
			CustomError usererr = new CustomError();
			
			// SETTING VALUES FOR EXCEPTION
			usererr.setStatus(HttpStatus.BAD_REQUEST.value());
			usererr.setMsg(exc.getMessage());
			usererr.setTimestamp(System.currentTimeMillis());
			
			// RETURNING ERROR RESPONSE WITH GETTER VALUES AND STATUS CODE
			return new ResponseEntity<>(usererr, HttpStatus.BAD_REQUEST);
		}

}
