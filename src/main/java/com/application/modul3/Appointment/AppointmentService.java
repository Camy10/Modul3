package com.application.modul3.Appointment;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.exemplary.Exemplary;
import com.application.modul3.exemplary.ExemplaryRepository;
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
	private ExemplaryRepository exemplaryRepository;
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

	public List<Exemplary> findFreeExemplaries(LocalDate dateFrom, LocalDate dateUntil, Integer bookId) {
		return exemplaryRepository.getExemplariesForUserAndPeriod(dateFrom, dateUntil, bookId);
	}

}
