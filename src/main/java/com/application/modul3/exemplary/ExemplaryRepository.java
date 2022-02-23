package com.application.modul3.exemplary;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//Repostory este o interfata ce are rol de a stoca, de a accesa datele din db
public interface ExemplaryRepository extends JpaRepository<Exemplary, Integer> {
	//@Query(value = "SELECT exemplary FROM exemplary exemplary inner join exemplary.book WHERE book.id = ?1")
	List<Exemplary> findExemplariesByBookId(Integer bookId);
	List<Exemplary> findExemplariesByPublisherId(Integer publisherId);
	

	@Query(value = "SELECT DISTINCT exemplary FROM exemplary exemplary inner join exemplary.book book left"
			+ " join exemplary.appointments appointment WHERE exemplary.id NOT IN "
			+ "(SELECT ex.id FROM appointment ap JOIN ap.exemplary ex WHERE ?1 <= ap.dateUntil "
			+ "AND ?2 >= ap.dateFrom)" + "AND (book.id = ?3)")
	List<Exemplary> getExemplariesForUserAndPeriod(LocalDate dateFrom, LocalDate dateUntil, Integer bookId);

	
}
