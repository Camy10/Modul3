package com.application.modul3.person.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.application.modul3.person.Person;
import com.application.modul3.person.dto.PersonCreateDTO;
import com.application.modul3.person.dto.PersonDTO;

@Component
public class PersonMapper {

	public Person personCreateDTO2person(PersonCreateDTO personCreateDTO) {
		Person person = new Person();
		person.setLastName(personCreateDTO.getLastName());
		person.setFirstName(personCreateDTO.getFirstName());
		person.setAge(personCreateDTO.getAge());
		return person;
	}

	public PersonDTO person2PersonDTO(Person person) {
		PersonDTO personDTO = new PersonDTO();
		personDTO.setId(person.getId());
		personDTO.setLastName(person.getLastName());
		personDTO.setFirstName(person.getFirstName());
		personDTO.setAge(person.getAge());
		return personDTO;
	}

	public Person personDTO2Person(PersonDTO personDTO) {
		Person person = new Person();
		person.setId(personDTO.getId());
		person.setLastName(personDTO.getLastName());
		person.setFirstName(personDTO.getFirstName());
		person.setAge(personDTO.getAge());
		return person;
	}

	public List<PersonDTO> personList2PersonListDTO(List<Person> persons) {
		return persons.stream().map(person -> person2PersonDTO(person)).collect(Collectors.toList());
	}

}
