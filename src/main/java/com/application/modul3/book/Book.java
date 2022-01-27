package com.application.modul3.book;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.application.modul3.exemplary.Exemplary;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "book", schema = "administration")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "title")
	private String title;

	@Column(name = "year")
	private LocalDate yearBook; // LocalDate ->"yyyy-mm-dd"

	@Column(name = "isbn")
	private String isbn;

	//entitatea parinte 
	@OneToMany(mappedBy = "book", cascade = { CascadeType.ALL}, orphanRemoval = true)
	 @JsonIgnoreProperties("book")
	private Set<Exemplary> exemplaries;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitleBook() {
		return title;
	}

	public void setTitleBook(String titleBook) {
		this.title = titleBook;
	}

	public LocalDate getYearBook() {
		return yearBook;
		// return LocalDate.yearBook.getYear() ;
	}

	public void setYearBook(String date) {
		this.yearBook = LocalDate.parse(date);
	}

	public String getIsbnBook() {
		return isbn;
	}

	public void setIsbnBook(String isbn) {
		this.isbn = isbn;
	}
	
	//add un exemplar de carte
	public void addExemplary(Exemplary exemplary) {
		this.exemplaries.add(exemplary);
		exemplary.setBook(this);
	}
	
	//stergerea unui exemplar
	public void removeExemplary(Exemplary exemplary) {
		this.exemplaries.remove(exemplary);
		exemplary.setBook(null);	
	}
	
	public Set<Exemplary> getExemplaries(){
		return exemplaries;
	}
	public void setExemplaries(Set<Exemplary> exemplaries) {
		this.exemplaries = exemplaries;		
	}
	
}
