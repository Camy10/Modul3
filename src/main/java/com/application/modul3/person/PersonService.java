package com.application.modul3.person;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.application.modul3.car.Car;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;

	public Person createperson(Person person) {
		return personRepository.saveAndFlush(person);
	}

	public Person updatePerson(Person person, Integer personId) {
		Person updatePerson = getPersonById(personId);
		updatePerson.setLastName(person.getLastName());
		updatePerson.setFirstName(person.getFirstName());
		updatePerson.setAge(person.getAge());
		personRepository.flush();
		return updatePerson;
	}

	public List<Person> getAllPerson() {
		return personRepository.findAll();
	}

	public Person getPersonById(Integer personId) {
		Optional<Person> optperson = personRepository.findById(personId);
		if (optperson.isPresent()) {
			return optperson.get();
		}
		return null;
	}

	public void deletePersonById(Integer personId) {
		personRepository.deleteById(personId);
	}

	public void deletefromUserCarId(Integer personId, Integer carId) {
		Person person = getPersonById(personId);
		person.getCars();
		Car car = person.getCarWithId(carId);
		// Car car = carService.getCarById(carId); imi da dependinta circulara
		person.removeCar(car);
		personRepository.flush();
	}

}
