package com.application.modul3.exception;

public class DateIsWrong extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public DateIsWrong(String ms) {
		super(ms);
	}
}
