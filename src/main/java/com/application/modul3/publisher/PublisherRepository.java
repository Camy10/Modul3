package com.application.modul3.publisher;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
//	@Query("SELECT publisher FROM publisher publisher inner join publisher.book book WHERE book.id = ?1")
//	List<Publisher> findPublisersByBookId(Integer bookId);

	public  List<Publisher> findByName(String name);
}

