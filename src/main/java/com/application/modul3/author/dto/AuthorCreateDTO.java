package com.application.modul3.author.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.application.modul3.gender.Gender;

public class AuthorCreateDTO {
	private Integer id;
	private String name;
	private LocalDate birthDate;
	private Gender gender;
	private LocalDate deathDate;
	private String nationality;
	private Set<Integer> booksId = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public LocalDate getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(LocalDate deathDate) {
		this.deathDate = deathDate;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Set<Integer> getBooksId() {
		return booksId;
	}

	public void setBooksId(Set<Integer> booksId) {
		this.booksId = booksId;
	}

}
