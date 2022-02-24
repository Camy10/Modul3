package com.application.modul3.exception;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	// handle sepecific exception
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handlerStudentNotFoundException(ResourceNotFoundException exception) {
		// 2 pune LocalDateTime in loc de Date
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		ErrorDetails error = new ErrorDetails(LocalDateTime.now(), httpStatus.value(), httpStatus.getReasonPhrase(),
				exception.getMessage());

		 //return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND) ;
		// doar mesajul
		return new ResponseEntity<>(error, httpStatus);
	}

	// handle global exception
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<?> handlerGlobalException(Exception exception, WebRequest request){
//		ErrorDetails error = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
//		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);	
//	}

}
