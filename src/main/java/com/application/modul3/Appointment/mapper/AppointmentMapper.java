package com.application.modul3.Appointment.mapper;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.application.modul3.Appointment.Appointment;
import com.application.modul3.Appointment.dto.AppointmentCreateDTO;
import com.application.modul3.Appointment.dto.AppointmentDTO;
import com.application.modul3.exemplary.mapper.ExemplaryMapper;



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
		appointmentDTO.setExemplaryId(appointment.getExemplary().getId());
			
		return appointmentDTO;		
	}

	

	public List<AppointmentDTO> appointmentList2AppointmentListDTO(
			List<Appointment> appointments) {
		return appointments.stream().map(appointment -> appointment2AppointmentDTO(appointment)).collect(Collectors.toList());
	}
}
