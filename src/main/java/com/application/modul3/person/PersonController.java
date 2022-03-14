package com.application.modul3.person;

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
import com.application.modul3.person.dto.PersonCreateDTO;
import com.application.modul3.person.dto.PersonDTO;
import com.application.modul3.person.mapper.PersonMapper;

@RestController
@RequestMapping("/persons")
public class PersonController {
	@Autowired
	private PersonService personService;

	@Autowired
	private PersonMapper personMapper;

	// person -POST (primeste un PersonCreateDTO) si va returna un PersonDTO)
	@PostMapping
	public PersonDTO createPerson(@RequestBody PersonCreateDTO personCreateDTO) {
		Person person = personService.createperson(personMapper.personCreateDTO2person(personCreateDTO));
		return personMapper.person2PersonDTO(person);
	}

	// person/{id} - PUT (primeste un PersonDTO, va returna un PersonDTO)
	@PutMapping("/person/{personId}")
	public PersonDTO updatePerson(@RequestBody PersonDTO personDTO, @PathVariable Integer personId) {
		Person person = personService.updatePerson(personMapper.personDTO2Person(personDTO), personId);
		return personMapper.person2PersonDTO(person);
	}

	// person - GET (returneaza List<PersonDTO>)
	@GetMapping("/list")
	public List<PersonDTO> getAllPerson() {
		return personMapper.personList2PersonListDTO(personService.getAllPerson());
	}

	// person/get/{id} - GET (returneaza o persoana dupa ID)
	@GetMapping("/{personId}")
	public PersonDTO getPersonById(@PathVariable Integer personId) {
		return personMapper.person2PersonDTO(personService.getPersonById(personId));
	}

	// person/{id} - DELETE (sterge o persoana dupa ID)
	@DeleteMapping("/person/{personId}")
	public void deletePersonId(@PathVariable Integer personId) {
		personService.deletePersonById(personId);
	}

	/*
	 * person/remove-from-user/{personId}/{carId} -> GET fara body -> in Service,
	 * asta se face prin acel remove bidirectional. Testati urmatorul lucru: daca
	 * orphanRemoval = true, verificati daca a sters cu totul masina din baza de
	 * date. Daca orphanRemoval = false, verificati ca doar a pus FK pe null in
	 * tabela Masina
	 */
	@DeleteMapping("/person/remove-from-user/{personId}/{carId}")
	public void deletefromUserCarId(@PathVariable Integer personId, @PathVariable Integer carId) {
		personService.deletefromUserCarId(personId, carId);
	}
}
