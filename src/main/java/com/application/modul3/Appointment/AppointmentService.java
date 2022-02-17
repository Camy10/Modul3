package com.application.modul3.Appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.exemplary.Exemplary;
import com.application.modul3.exemplary.ExemplaryService;
import com.application.modul3.user.User;
import com.application.modul3.user.UserService;

@Service
public class AppointmentService {
	@Autowired
	private AppointmentRepository appointmentRepository;
	@Autowired
	private ExemplaryService exemplaryService;
	@Autowired
	private UserService userService;

	public Appointment createAppointment(Appointment appointment, Integer userId, Integer exemplaryId) {
		Exemplary exemplary = exemplaryService.getExemplaryById(exemplaryId);
		User user = userService.getUserById(userId);

		exemplary.addAppointment(appointment);
		user.addAppointment(appointment);
		//appointment.setExemplary(exemplary);
		//appointment.setUser(user);
		return appointmentRepository.saveAndFlush(appointment);
	}

}
