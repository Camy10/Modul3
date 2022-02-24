package com.application.modul3.exception;

import java.time.LocalDateTime;
import java.util.Date;

public class ErrorDetails {
	private LocalDateTime timestamp;
	private Integer status;
	private String error;
	private String message;

	public ErrorDetails(LocalDateTime timestamp, Integer status, String error, String message) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
