package com.application.modul3.city;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.exception.ResourceNotFoundException;

@Service
public class CityService {
	
	@Autowired
	private CityRepository cityRepository;

	public City createCity(City city) {
		return cityRepository.saveAndFlush(city);
	}

	public List<City> getAllCity() {
		return cityRepository.findAll();
	}

	public City updateCityById(City city, Integer id) {
		City updateCity = getCityById(id);
		updateCity.setName(city.getName());
		cityRepository.flush();
		return updateCity;
	}

	public City getCityById(Integer id) {
		
		return cityRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("City not found"));
	}

	public void deleteById(Integer id) {
	
		 cityRepository.deleteById(id);
	}

}
