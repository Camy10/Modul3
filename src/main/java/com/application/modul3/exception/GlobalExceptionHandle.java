package com.application.modul3.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandle extends ResponseEntityExceptionHandler {
	// handle sepecific exception
	@ExceptionHandler(ResourceNotFoundException.class)

	public ResponseEntity<?> handlerStudentNotFoundException(ResourceNotFoundException exception, WebRequest request) {

		ErrorDetails error = new ErrorDetails(new Date(), HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.getReasonPhrase(), exception.getMessage(), request.getDescription(false));

		// return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND) apare
		// doar mesajul
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.NOT_FOUND);
	}

	// handle global exception
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<?> handlerGlobalException(Exception exception, WebRequest request){
//		ErrorDetails error = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
//		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);	
//	}

}
