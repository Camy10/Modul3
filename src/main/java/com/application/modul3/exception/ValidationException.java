package com.application.modul3.exception;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public ValidationException(String ms) {
		super(ms);
	}
}
