package com.application.modul3.book.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

//DTO - Data Transfer Object -> arata 1:1 ca si campuri cu entitatile pe care le folosim la BD
public class BookCreateDTO {
	private Integer id;
	private String title;
	private LocalDate year;
	private String isbn;
	private Set<Integer> authorIds;
	// private List<ExemplaryDTO> exemplaryDTO; -> de facut getter +setter

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getYear() {
		return year;
	}

	public void setYear(LocalDate year) {
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<Integer> getAuthorIds() {
		return authorIds;
	}

	public void setAuthorIds(Set<Integer> authorIds) {
		this.authorIds = authorIds;
	}
}
