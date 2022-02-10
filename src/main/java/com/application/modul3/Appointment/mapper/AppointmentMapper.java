package com.application.modul3.Appointment.mapper;

import org.springframework.stereotype.Component;

import com.application.modul3.Appointment.Appointment;
import com.application.modul3.Appointment.dto.AppointmentCreateDTO;

@Component
public class AppointmentMapper {

	public Appointment appointmentCreateDTO2Appointment(AppointmentCreateDTO appointmentCreateDTO) {
		Appointment appointment = new Appointment();
		appointment.setDateFrom(appointmentCreateDTO.getDateFrom());
		appointment.setDateUntil(appointmentCreateDTO.getDateUntil());
		return appointment;
	}

}
