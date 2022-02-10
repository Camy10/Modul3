package com.application.modul3.book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.author.Author;
import com.application.modul3.author.AuthorService;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorService authorService;

	// cream o inregistre si o salvam
	public Book createBook(Book book) {
		return bookRepository.saveAndFlush(book);
	}

	// cream o carte la care ii add o lista de autori
	public Book createBook(Book book, Set<Integer> authorIds) {
		Set<Author> authors = authorService.getAuthors(authorIds);
		for (Author author : authors) {
			book.addAuthor(author);
		}
		return bookRepository.save(book);
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
		bookUpdate.setYearBook(book.getYearBook());
		bookUpdate.setIsbnBook(book.getIsbnBook());
		bookRepository.flush();
		return bookUpdate;
	}

	// find a book by title
	public List<Book> getBookByTitle(String title) {
		return bookRepository.findByTitle(title);
	}

	/*
	 * caut cartea dupa id la cartea gasita ii aducem autorii
	 * 
	 */
	public Book findBookWithAuthorsID(Integer bookId) {
		Book book = getBookById(bookId);
		book.getAuthors();
		return book;
	}
	
	public Book findBookWithAuthors(Integer bookId) {
		Book book = getBookById(bookId);
		book.getAuthors();
		return book;
	}


	public Set<Book> getBooksWithId(Set<Integer> booksId) {
		
		return bookRepository.findByIdIn(booksId);
	}

}
