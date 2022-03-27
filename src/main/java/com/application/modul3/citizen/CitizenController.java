package com.application.modul3.citizen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/citizens")
public class CitizenController {
	
	@Autowired
	private CitizenService citizenService;
	
	@PostMapping("/add-city/{cityId}")
	public Citizen createCritizen(@RequestBody Citizen citizen, @PathVariable Integer cityId) {
		return citizenService.create(citizen, cityId);
	}
	
	
	@DeleteMapping("/{cityId}/{citizenId}")
	public void deleteById(@PathVariable Integer cityId, @PathVariable Integer citizenId) {
		citizenService.deleteById(cityId, citizenId);
		
	}

}
