package com.application.modul3.book;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

	public List<Book> findByTitle(String title);
	public Set<Book> findByIdIn(Set<Integer> booksId);
}
