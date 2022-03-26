package com.application.modul3.Appointment.dto;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AppointmentDTO {

	private Integer id;
	
//	@JsonFormat(pattern = "yyyy-MM-dd")
//	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalDate dateFrom;
	
//	@JsonFormat(pattern = "yyyy-MM-dd")
//	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalDate dateUntil;
	
	
	private Integer exemplaryId;
	
	
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
	public Integer getExemplaryId() {
		return exemplaryId;
	}
	public void setExemplaryId(Integer exemplaryId) {
		this.exemplaryId = exemplaryId;
	}
	
	
}
