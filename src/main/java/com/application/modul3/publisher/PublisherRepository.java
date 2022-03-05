package com.application.modul3.publisher;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
//	@Query("SELECT publisher FROM publisher publisher inner join publisher.book book WHERE book.id = ?1")
//	List<Publisher> findPublisersByBookId(Integer bookId);

	public Publisher findByName(String name);
}

