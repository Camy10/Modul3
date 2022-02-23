package com.application.modul3.Appointment.dto;

import java.time.LocalDate;

public class AppointmentDTO {

	private Integer id;
	private LocalDate dateFrom;
	private LocalDate dateUntil;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}
	public LocalDate getDateUntil() {
		return dateUntil;
	}
	public void setDateUntil(LocalDate dateUntil) {
		this.dateUntil = dateUntil;
	}
	
}
