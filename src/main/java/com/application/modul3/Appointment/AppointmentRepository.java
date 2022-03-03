package com.application.modul3.Appointment;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AppointmentRepository  extends JpaRepository<Appointment, Integer>{
	@Query(value = "SELECT appointment FROM appointment appointment inner join appointment.user WHERE user_id = ?1")
	List<Appointment> getAllAppWithUserId(Integer userId);

}
