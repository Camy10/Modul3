package com.application.modul3.car.mapper;

import org.springframework.stereotype.Service;

import com.application.modul3.car.Car;
import com.application.modul3.car.dto.CarCreateDTO;
import com.application.modul3.car.dto.CarDTO;

@Service
public class CarMapper {

	public Car carCreateDTO2Car(CarCreateDTO carCreateDTO) {
		Car car = new Car();
		car.setMark(carCreateDTO.getMark());
		car.setModel(carCreateDTO.getModel());
		car.setPower(carCreateDTO.getPower());
		car.setYear(carCreateDTO.getYear());
		return car;
	}

	public CarDTO Car2CarDTO(Car car) {
		CarDTO carDTO = new CarDTO();
		carDTO.setId(car.getId());
		carDTO.setMark(car.getMark());
		carDTO.setModel(car.getModel());
		carDTO.setYear(car.getYear());
		carDTO.setPower(car.getPower());
		return carDTO;
	}

}
