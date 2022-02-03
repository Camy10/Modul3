package com.application.modul3.exemplary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


//Repostory este o interfata ce are rol de a stoca, de a accesa datele din db
public interface ExemplaryRepository extends JpaRepository<Exemplary, Integer> {
	//@Query(value = "SELECT exemplary FROM exemplary exemplary inner join exemplary.book WHERE book.id = ?1")
	List<Exemplary> findExemplariesByBookId(Integer bookId);
	

}
