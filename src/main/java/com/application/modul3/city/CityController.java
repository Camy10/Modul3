package com.application.modul3.city;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.modul3.city.dto.CityCreateDTO;
import com.application.modul3.city.dto.CityDTO;
import com.application.modul3.city.mapper.CityMapper;

@RestController
@RequestMapping("/cities")
public class CityController {
	
	@Autowired
	private CityService cityService;
	@Autowired
	private CityMapper cityMapper;
	
	@PostMapping()
	public CityDTO createCity(@RequestBody CityCreateDTO cityCreateDTO) {
		City city = cityService.createCity(cityMapper.cityCreateDTO2City(cityCreateDTO));
		return cityMapper.city2CityDTO(city);	
	}
	
	@GetMapping("/list")
	public List<CityDTO> getAllCity(){
		return cityMapper.cityList2CityListDTO(cityService.getAllCity());
	}
	
	@GetMapping("/{id}")
	public CityDTO getCityById(@PathVariable Integer id){
		return cityMapper.city2CityDTO(cityService.getCityById(id));
	}
	
	@PutMapping("/{id}")
	public CityDTO updateCityById(@RequestBody CityDTO cityDTO, @PathVariable Integer id) {
		City city = cityService.updateCityById(cityMapper.cityDTO2City(cityDTO), id);
		return cityMapper.city2CityDTO(city);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCityById(@PathVariable Integer id) {
		 cityService.deleteById(id);
	}
	
	

}
