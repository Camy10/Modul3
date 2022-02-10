package com.application.modul3.Appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.modul3.Appointment.dto.AppointmentCreateDTO;
import com.application.modul3.Appointment.mapper.AppointmentMapper;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	@Autowired
	AppointmentService appointmentService;
	@Autowired
	AppointmentMapper appointmentMapper;

	@PostMapping()
	public Appointment createAppointment(@RequestBody AppointmentCreateDTO appointmentDTO) {
		return appointmentService.createAppointment(appointmentMapper.appointmentCreateDTO2Appointment(appointmentDTO),
				appointmentDTO.getUserId(), appointmentDTO.getExemplaryId());
	}
}
