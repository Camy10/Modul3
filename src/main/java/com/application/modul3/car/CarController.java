package com.application.modul3.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.modul3.car.dto.CarCreateDTO;
import com.application.modul3.car.dto.CarDTO;
import com.application.modul3.car.mapper.CarMapper;

@RestController
@RequestMapping("/cars")
public class CarController {
	@Autowired
	private CarService carService;
	@Autowired
	private CarMapper carMapper;
	
	@PostMapping
	public CarDTO createCar(@RequestBody CarCreateDTO carCreateDTO) {
		Car car = carService.createCar(carMapper.carCreateDTO2Car(carCreateDTO));
		return carMapper.Car2CarDTO(car);		
	}

	@PostMapping("/{personId}")
	public CarDTO createCarAdd(@RequestBody CarCreateDTO carCreateDTO, @PathVariable Integer personId) {
		Car car = carService.createCarAdd(carMapper.carCreateDTO2Car(carCreateDTO), personId);
		return carMapper.Car2CarDTO(car);	
	}
	
	@DeleteMapping("car/{carId}")
	public void  deleteCarId(@PathVariable Integer carId) {
		carService.deleteCarId(carId);
	}
}
