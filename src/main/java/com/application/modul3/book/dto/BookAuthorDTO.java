package com.application.modul3.book.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.application.modul3.author.dto.AuthorDTO;

public class BookAuthorDTO {
	private Integer id;
	private String title;
	private LocalDate year;
	private String isbn;
	private List<AuthorDTO> authorsDTO = new ArrayList<>();

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

	public List<AuthorDTO> getAuthorsDTO() {
		return authorsDTO;
	}

	public void setAuthorsDTO(List<AuthorDTO> authorsDTO) {
		this.authorsDTO = authorsDTO;
	}

}
