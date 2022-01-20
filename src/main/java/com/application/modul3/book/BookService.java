package com.application.modul3.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	// cream o inregistre si o salvam
	public Book createBook(Book book) {
		return bookRepository.saveAndFlush(book);
	}

	// obtinem toate inre din db
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	// obtinem o inregistare dupa id
	public Book getBookById(Integer id) {
		// declaram o carte optionala ca fiind cartea cu id- specificat
		Optional<Book> bookOpt = bookRepository.findById(id);
		if (bookOpt.isPresent()) {
			return bookOpt.get();
		}
		return null;
	}

	// stergerea unei carte
	public void deleteBookById(Integer id) {
		bookRepository.deleteById(id);
	}

	// update
	public Book updateBook(Book book, Integer id) {
		Book bookUpdate = getBookById(id);
		bookUpdate.setTitleBook(book.getTitleBook());
		bookUpdate.setYearBook(String.valueOf(book.getYearBook()));
		bookUpdate.setIsbnBook(book.getIsbnBook());
		bookRepository.flush();
		return bookUpdate;
	}

	public List<Book> findByTitle(String title) {
		List<Book> listBookByTitle = new ArrayList<>();
				
		listBookByTitle.addAll(bookRepository.findByTitle(title));
		
		return listBookByTitle;

	}

}
