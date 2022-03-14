package com.application.modul3.book.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.application.modul3.author.mapper.AuthorMapper;
import com.application.modul3.book.Book;
import com.application.modul3.book.dto.BookAuthorDTO;
import com.application.modul3.book.dto.BookCreateDTO;
import com.application.modul3.book.dto.BookDTO;
import com.application.modul3.exemplary.mapper.ExemplaryMapper;

@Component
public class BookMapper {
	//@Autowired ExemplaryMapper exemplaryMapper;
	@Autowired AuthorMapper authorMapper;
	
	//metoda returneaza un bookDTO,  mapeaza din book in bookDTO
	public BookDTO book2BookDTO(Book book) {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setId(book.getId());
		bookDTO.setTitle(book.getTitleBook());
		bookDTO.setYear(book.getYearBook());
		bookDTO.setIsbn(book.getIsbnBook());
		//bookDTO.setExemplaryListDTO(exemplaryMapper.exemplaryList2ExemplaryListDTO(book.getExemplaryList()));
		return bookDTO;	
	}
	
	public Book bookDTO2Book(BookDTO bookDTO) {
		Book book = new Book();
		book.setTitleBook(bookDTO.getTitle());
		book.setYearBook(bookDTO.getYear());
		book.setIsbnBook(bookDTO.getIsbn());
		return book;		
	}
	
	public Book bookCreateDTO2Book(BookCreateDTO bookDTO) {
		Book book = new Book();
		book.setTitleBook(bookDTO.getTitle());
		book.setYearBook(bookDTO.getYear());
		book.setIsbnBook(bookDTO.getIsbn());
	
		
		return book;		
	}
	
	public List<BookDTO> bookList2BookListDTO(List<Book> books){
		return books
				.stream()
				.map(book -> book2BookDTO(book))
				.collect(Collectors.toList());
		
//		List<BookDTO> bookListDTO = new ArrayList<>();
//		for(Book book : books) {
//			bookListDTO.add(book2BookDTO(book));
//		}
//		return bookListDTO;
	}
	
	

	public BookCreateDTO book2BookCreateDTO(Book book) {
		BookCreateDTO bookCreateDTO = new BookCreateDTO();
		bookCreateDTO.setTitle(book.getTitleBook());
		bookCreateDTO.setIsbn(book.getIsbnBook());
		bookCreateDTO.setYear(book.getYearBook());
		bookCreateDTO.setAuthorIds(book.getAuthorsIDS());
		return bookCreateDTO;
	}
	
	public BookAuthorDTO book2BookAuthorsDTO(Book book) {
		BookAuthorDTO bookAuthorsDTO = new BookAuthorDTO();
		bookAuthorsDTO.setId(book.getId());
		bookAuthorsDTO.setTitle(book.getTitleBook());
		bookAuthorsDTO.setIsbn(book.getIsbnBook());
		bookAuthorsDTO.setYear(book.getYearBook());
		bookAuthorsDTO.setAuthorsDTO(authorMapper.authorList2AuthorListDTO( new ArrayList<>(book.getAuthors())));
		return bookAuthorsDTO;
	}


}
