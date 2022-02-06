package com.application.modul3.publisher;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.application.modul3.book.Book;
import com.application.modul3.exemplary.Exemplary;

@Entity
@Table(name = "publisher", schema = "administration")
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@ManyToMany(mappedBy = "publishers", cascade = CascadeType.ALL)
	private Set<Book> books;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public void addBook(Book book) {
		this.books.add(book);
		book.addPublisher(this);
	}

	
	

}
