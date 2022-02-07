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
import com.application.modul3.book.dto.BookDTO;
import com.application.modul3.book.mapper.BookMapper;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private BookMapper bookMapper;

	@PostMapping
	public BookDTO createBook(@RequestBody BookDTO bookDTO) {
		Book createBook = bookService.createBook(bookMapper.bookDTO2Book(bookDTO));
		return bookMapper.book2BookDTO(createBook);
	}

	@GetMapping("/list")
	public List<BookDTO> getAllBook() {
		return bookMapper.bookList2BookListDTO(bookService.getAllBooks());
	}

	@GetMapping("/{id}")
	public BookDTO getBookById(@PathVariable Integer id) {
		return bookMapper.book2BookDTO(bookService.getBookById(id));
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
	public List<BookDTO> getBookByTitle(@RequestParam String title) {
		return bookMapper.bookList2BookListDTO(bookService.getBookByTitle(title));
	}

}
