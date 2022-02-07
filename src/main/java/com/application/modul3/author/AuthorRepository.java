package com.application.modul3.author;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
	//metodele derivate au 2 parti:  find/read/query/count/get ->Bykeyword
	public Author findByNameContaining(String name); 

	public List<Author> findByDeathDateIsNull();
	
	public Set<Author> findByIdIn(Set<Integer> authorIds);
}
