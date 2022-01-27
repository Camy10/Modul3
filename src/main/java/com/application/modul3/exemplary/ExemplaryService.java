package com.application.modul3.exemplary;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.book.Book;
import com.application.modul3.book.BookService;
@Service
public class ExemplaryService {
	
	@Autowired
	private ExemplaryRepository exemplaryRepository;
	
	@Autowired
	private BookService bookService;
	
	
	public Exemplary createExemplary(Integer bookId, Exemplary exemplary) {
		Book book= bookService.getBookById(bookId);
		book.addExemplary(exemplary);
		return exemplaryRepository.saveAndFlush(exemplary);	
	}
	
	public Set<Exemplary> getAllExemplary(){
		return new HashSet<>(exemplaryRepository.findAll()) ;
	}

	public Exemplary getExemplaryById(Integer id) {
		Optional<Exemplary> optExemplary = exemplaryRepository.findById(id);
		if (optExemplary.isPresent()) {
			return optExemplary.get();		
		}
		return null;
	}
	
	
	public void deleteExemplaryById(Integer id) {
		exemplaryRepository.deleteById(id);
	}
	
	//nu e testat
	public Exemplary updateExemplary(Exemplary exemplary, Integer id) {
		Exemplary updateExemplary = getExemplaryById(id);
		updateExemplary.setDate(exemplary.getDate());
		updateExemplary.setCode(exemplary.getCode());
		updateExemplary.setPageNumbers(exemplary.getPageNumbers());
		updateExemplary.setBook(exemplary.getBook());
		exemplaryRepository.flush();
		
		return updateExemplary;	
	}
	
}
