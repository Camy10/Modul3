package com.application.modul3.book.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.application.modul3.author.Author;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

//DTO - Data Transfer Object -> arata 1:1 ca si campuri cu entitatile pe care le folosim la BD
public class BookCreateDTO {
	
	private String title;
	private LocalDate year;
	private String isbn;
	private Set<Integer> authorIds = new HashSet<>();


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
