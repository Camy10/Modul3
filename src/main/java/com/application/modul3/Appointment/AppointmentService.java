package com.application.modul3.Appointment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.exception.DateIsWrong;
import com.application.modul3.exemplary.Exemplary;
import com.application.modul3.exemplary.ExemplaryRepository;
import com.application.modul3.exemplary.ExemplaryService;
import com.application.modul3.user.User;
import com.application.modul3.user.UserRepository;
import com.application.modul3.user.UserService;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

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
		// appointment.setExemplary(exemplary);
		// appointment.setUser(user);
		return appointmentRepository.saveAndFlush(appointment);
	}

	public List<Exemplary> findFreeExemplaries(LocalDate dateFrom, LocalDate dateUntil, Integer bookId) {
		LocalDate curentdate = LocalDate.now();
		if (dateFrom.isAfter(dateUntil)) {
			throw new DateIsWrong("Change the end date");
		} else if (dateFrom.equals(curentdate) || (dateFrom.isAfter(curentdate))) {
			return exemplaryRepository.getExemplariesForUserAndPeriod(dateFrom, dateUntil, bookId);
		}
		throw new DateIsWrong("Change the start date");
	}

	public List<Appointment> gettAllAppointment() {
		return appointmentRepository.findAll();
	}

	//user-ul vrea sa-si vada toate comenzile
	public List<Appointment> findAppointmnetByUserId(Integer userId) {
		// User user = userService.getUserById(userId);
		// user.getAppointments();
		return appointmentRepository.getAllAppWithUserId(userId);
	}

	public List<Exemplary> findFreeExemplariesByPublisher(LocalDate dateFrom, LocalDate dateUntil, String publisherByName) {
	
		return exemplaryRepository.getExemplariesForPublisherAndPeriod(dateFrom, dateUntil, publisherByName);
	}
}
