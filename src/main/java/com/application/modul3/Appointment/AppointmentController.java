package com.application.modul3.Appointment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.modul3.Appointment.dto.AppointmentCreateDTO;
import com.application.modul3.Appointment.dto.AppointmentDTO;
import com.application.modul3.Appointment.mapper.AppointmentMapper;
import com.application.modul3.exemplary.Exemplary;
import com.application.modul3.exemplary.dto.ExemplaryDTO;
import com.application.modul3.exemplary.mapper.ExemplaryMapper;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
	@Autowired
	private AppointmentMapper appointmentMapper;
	@Autowired
	private ExemplaryMapper exemplaryMapper;

	@PostMapping()
	public AppointmentDTO createAppointment(@RequestBody AppointmentCreateDTO appointmentCreateDTO) {
		Appointment app = appointmentService.createAppointment(
				appointmentMapper.appointmentCreateDTO2Appointment(appointmentCreateDTO),
				appointmentCreateDTO.getUserId(), appointmentCreateDTO.getExemplaryId());
		return appointmentMapper.appointment2AppointmentDTO(app);
	}

	/*
	 * creez un appointment unde ii dau in path userId si xemplaryId
	 */
	@PostMapping("/{userId}/{exemplaryId}")
	public AppointmentDTO createApp(@RequestBody AppointmentCreateDTO appointmentDTO, @PathVariable Integer userId,
			@PathVariable Integer exemplaryId) {
		Appointment ap = appointmentService.createAppointment(
				appointmentMapper.appointmentCreateDTO2Appointment(appointmentDTO), userId, exemplaryId);
		return appointmentMapper.appointment2AppointmentDTO(ap);
	}

	@GetMapping("/find/{startDate}/{endDate}/{bookId}")
	public List<ExemplaryDTO> findFreeExemplaries(@PathVariable String startDate, @PathVariable String endDate,
			@PathVariable Integer bookId) {

		List<Exemplary> freeExemplaries = appointmentService.findFreeExemplaries(LocalDate.parse(startDate),
				LocalDate.parse(endDate), bookId);
		return exemplaryMapper.exemplaryList2ExemplaryDTOlist(freeExemplaries);
	}
	
	//nu este testata
	@GetMapping("/find/{startDate}/{endDate}/ByName")
	public List<ExemplaryDTO> findFreeExemplariesByPublisher(@PathVariable String startDate, @PathVariable String endDate,
			@PathVariable String publisherByName) {

		
		List<Exemplary> freeExemplaries = appointmentService.findFreeExemplariesByPublisher(LocalDate.parse(startDate),
				LocalDate.parse(endDate), publisherByName);
		return exemplaryMapper.exemplaryList2ExemplaryDTOlist(freeExemplaries);
	}

	@GetMapping("/list")
	public List<AppointmentDTO> getAllAppointment() {
		return appointmentMapper.appointmentList2AppointmentListDTO(appointmentService.gettAllAppointment());
	}

	@GetMapping("/list/{userId}")
	public List<AppointmentDTO> getAppointmentsForUser(@PathVariable Integer userId) {
		List<Appointment> appointmentDBs = new ArrayList<>(appointmentService.getAllAppointmentsForUser(userId));
		return appointmentMapper.appointmentList2AppointmentListDTO(appointmentDBs);
	}

}
