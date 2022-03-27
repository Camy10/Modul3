package com.application.modul3.citizen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.city.City;
import com.application.modul3.city.CityService;
import com.application.modul3.exception.ResourceNotFoundException;

@Service
public class CitizenService {
	@Autowired
	private CitizenRepozitory citizenRepository;
	@Autowired
	private CityService cityService;

	public Citizen create(Citizen citizen, Integer id) {
		City city = cityService.getCityById(id);
		city.addCitizen(citizen);
		return citizenRepository.saveAndFlush(citizen);
	}

	public void deleteById(Integer cityId, Integer citizenId) {
		City city = cityService.getCityById(cityId);
		Citizen citizen = citizenRepository.findById(citizenId)
				.orElseThrow(() -> new ResourceNotFoundException("citizen not found"));

		city.removeCitizen(citizen);
		citizenRepository.flush();

	}

}
