package com.application.modul3.Appointment.mapper;

import org.springframework.stereotype.Component;

import com.application.modul3.Appointment.Appointment;
import com.application.modul3.Appointment.dto.AppointmentCreateDTO;
import com.application.modul3.Appointment.dto.AppointmentDTO;

@Component
public class AppointmentMapper {

	public Appointment appointmentCreateDTO2Appointment(AppointmentCreateDTO appointmentCreateDTO) {
		Appointment appointment = new Appointment();
		appointment.setDateFrom(appointmentCreateDTO.getDateFrom());
		appointment.setDateUntil(appointmentCreateDTO.getDateUntil());
		return appointment;
	}
	
	public AppointmentDTO appointment2AppointmentDTO(Appointment appointment) {
		AppointmentDTO appointmentDTO = new AppointmentDTO();
		appointmentDTO.setId(appointment.getId());
		appointmentDTO.setDateFrom(appointment.getDateFrom());
		appointmentDTO.setDateUntil(appointment.getDateUntil());

		return appointmentDTO;		
	}

}
