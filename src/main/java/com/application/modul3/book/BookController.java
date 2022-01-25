package com.application.modul3.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping
	public Book createBook(@RequestBody Book book) {
		return bookService.createBook(book);
	}

	@GetMapping("/list")
	public List<Book> getAllBook() {
		return bookService.getAllBooks();
	}

	@GetMapping("/id={id}")
	public Book getBookById(@PathVariable Integer id) {
		return bookService.getBookById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteBookById(@PathVariable Integer id) {
		bookService.deleteBookById(id);
	}

	@PutMapping("/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable Integer id) {
		return bookService.updateBook(book, id);
	}
	
	@GetMapping("/title/name")
	public  List<Book>  getBookByTitle(@RequestParam String title) {
		return  bookService.getBookByTitle(title);
	}

}
