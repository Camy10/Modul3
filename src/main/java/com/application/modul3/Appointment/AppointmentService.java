package com.application.modul3.Appointment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.exception.ResourceNotFoundException;
import com.application.modul3.exception.ValidationException;
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
	private ExemplaryRepository exemplaryRepository;
	
	@Autowired
	private UserRepository userRepository;

	public Appointment createAppointment(Appointment appointment, Integer userId, Integer exemplaryId) {
		if(appointment.getDateFrom().isAfter(appointment.getDateUntil())){
			throw new ValidationException("End date of the appointment is before start date");
			}
		
		Exemplary exemplary = exemplaryRepository.findById(exemplaryId)
				.orElseThrow(() -> new ResourceNotFoundException("Exemplary not found"));
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));
		
		if (!findFreeExemplaries(appointment.getDateFrom(), appointment.getDateUntil(), exemplary.getBook().getId())
				.contains(exemplary)) {
			throw new ValidationException("The exemplary was reserved by somebody else");
		}
		exemplary.addAppointment(appointment);
		user.addAppointment(appointment);

		return appointmentRepository.saveAndFlush(appointment);
	}

	public List<Exemplary> findFreeExemplaries(LocalDate dateFrom, LocalDate dateUntil, Integer bookId) {
		LocalDate curentdate = LocalDate.now();
		if (dateFrom.isAfter(dateUntil)) {
			throw new ValidationException("Change the end date");
		} else if (dateFrom.equals(curentdate) || (dateFrom.isAfter(curentdate))) {
			return exemplaryRepository.getExemplariesForUserAndPeriod(dateFrom, dateUntil, bookId);
		}
		throw new ValidationException("Change the start date");
	}


	public List<Appointment> gettAllAppointment() {
		return appointmentRepository.findAll();
	}
	
	public Set<Appointment> getAllAppointmentsForUser(Integer userId) {
		return appointmentRepository.findByUser(userId);
	}


	public List<Exemplary> findFreeExemplariesByPublisher(LocalDate dateFrom, LocalDate dateUntil, String publisherByName) {
	
		return exemplaryRepository.getExemplariesForPublisherAndPeriod(dateFrom, dateUntil, publisherByName);
	}
	
	public void deleteById(Integer appId) {
		appointmentRepository.deleteById(appId);	
	}
}
