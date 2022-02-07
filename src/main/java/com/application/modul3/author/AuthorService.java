package com.application.modul3.author;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.book.Book;
import com.application.modul3.book.BookService;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepository;
	
	//incercare
		@Autowired BookService bookService;
		
		//incercare
		public Author createBookAuthor(Author author,  Integer bookId) {
			//List<Book> books= new ArrayList<Book>();
			Book book = bookService.getBookById(bookId);
			//author.addBook(book);	
			
			book.addAuthor(author);
			return authorRepository.saveAndFlush(author);	
		}

	// crearea si salvarea unui autor in db
	public Author createAuthor(Author author) {
		return authorRepository.saveAndFlush(author);
	}

	// obtinerea tuturor autorilor
	public List<Author> getAllAuthor() {
		return authorRepository.findAll();
	}

	// obtinerea unui autor dupa id
	public Author getAuthorById(Integer id) {
		Optional<Author> authorOpt = authorRepository.findById(id);
		if (authorOpt.isPresent()) {
			return authorOpt.get();
		}
		return null;
	}

	// stergerea unui autor
	public void deleteAuthorById(Integer id) {
		authorRepository.deleteById(id);
	}

	// modificarea unei caracteristici ale unui autor
	public Author updateAuthorById(Author author, Integer id) {
		Author updateAuthor = getAuthorById(id);
		updateAuthor.setName(author.getName());
		updateAuthor.setBirthDate(author.getBirthDate());
		updateAuthor.setGender(author.getGender());
		updateAuthor.setDeathDate(author.getDeathDate());
		updateAuthor.setNationality(author.getNationality());
		authorRepository.flush();
		return updateAuthor;
	}

	// gasirea unui autor dupa nume
	public Author getAuthorByName(String name) {
		return authorRepository.findByNameContaining(name);
	}

	// gasirea autorilor care nu au decedat
	public List<Author> getAuthorWhoLive() {
		return authorRepository.findByDeathDateIsNull();
	}

}
