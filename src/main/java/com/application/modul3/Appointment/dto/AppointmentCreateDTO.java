package com.application.modul3.Appointment.dto;
import java.time.LocalDate;
public class AppointmentCreateDTO {

	private LocalDate dateFrom;
	private LocalDate dateUntil;
	private Integer exemplaryId;
	private Integer userId;

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

	public Integer getExemplaryId() {
		return exemplaryId;
	}

	public void setExemplaryId(Integer exemplaryId) {
		this.exemplaryId = exemplaryId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
