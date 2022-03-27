package com.application.modul3.city.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.application.modul3.city.City;
import com.application.modul3.city.dto.CityCreateDTO;
import com.application.modul3.city.dto.CityDTO;
@Component
public class CityMapper {
	
	public City cityCreateDTO2City(CityCreateDTO cityCreateDTO) {
		City city = new City();
		city.setName(cityCreateDTO.getName());
		return city;		
	}
	
	public CityDTO city2CityDTO(City city) {
		CityDTO cityDTO = new CityDTO();
		cityDTO.setId(city.getId());
		cityDTO.setName(city.getName());
		return cityDTO;		
	}
	
	public City cityDTO2City(CityDTO cityDTO) {
		City city = new City();
		city.setId(cityDTO.getId());
		city.setName(cityDTO.getName());
		return city;		
	}
	
	public List<CityDTO> cityList2CityListDTO(List<City> list){
		return list.stream()
				.map(city -> city2CityDTO(city))
				.collect(Collectors.toList());
	}

}
