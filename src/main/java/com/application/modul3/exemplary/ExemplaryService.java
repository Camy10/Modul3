package com.application.modul3.exemplary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.application.modul3.book.Book;
import com.application.modul3.book.BookService;
import com.application.modul3.publisher.Publisher;
import com.application.modul3.publisher.PublisherService;

@Service
public class ExemplaryService {

	@Autowired
	private ExemplaryRepository exemplaryRepository;
	@Autowired
	private BookService bookService;
	@Autowired
	private PublisherService publisherService;

	// la un exemplar add o carte si setez o editura
	public Exemplary createExemplary(Integer bookId, Integer publisherId, Exemplary exemplary) throws Exception {
		Book book = bookService.getBookById(bookId);
		if (book == null) {
			throw new Exception("Book with id " + bookId + " was not found");
		}
		Publisher publiser = publisherService.getPublisherById(publisherId);

		// one to many + many to one (bidirectional)
		book.addExemplary(exemplary);

		// doar many to one (doar exemplatul stie ce editura are, nu si invers)
		exemplary.setPublisher(publiser);

		return exemplaryRepository.saveAndFlush(exemplary);
	}

	public void deleteExemplary(Integer ExemplaryId) {
		exemplaryRepository.deleteById(ExemplaryId);
	}

	public List<Exemplary> findExemplariesByBookId(Integer bookId) {
		return exemplaryRepository.findExemplariesByBookId(bookId);
		/*
		 * SELECT exemplary.id, exemplary.date, exemplary.code FROM
		 * administartion.exemplary INNER JOIN administration.book ON exemplary.book_id
		 * = book.id WHERE book.id = :bookId
		 */
	}

	public List<Exemplary> findExemplaryByPublisherId(Integer publisherId) {
		return exemplaryRepository.findExemplariesByPublisherId(publisherId);

	}

	public List<Exemplary> getAllExemplary() {
		return exemplaryRepository.findAll();
	}

	public Exemplary getExemplaryById(Integer id) {
		return exemplaryRepository.getById(id);
	}

//	//nu e testat- nu merge
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
