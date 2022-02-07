package com.application.modul3.publisher;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.application.modul3.book.Book;
import com.application.modul3.book.BookService;

@Service
public class PublisherService {

	@Autowired
	PublisherRepository publisherRepository;

	@Autowired
	private BookService bookService;

	public Publisher createPublisher(Publisher publisher) {
		return publisherRepository.saveAndFlush(publisher);
	}

//	public void setPublisherBook(Integer bookId, Integer publisherId) {
//		Book book = bookService.getBookById(bookId);
//		Publisher publisher = getPublisherById(publisherId);
//		publisher.addBook(book);
//		publisherRepository.saveAndFlush(publisher);
//	}

	public List<Publisher> getAllPublisher() {
		return publisherRepository.findAll();
	}

	public Publisher getPublisherById(Integer id) {
		Optional<Publisher> publisherOpt = publisherRepository.findById(id);
		if (publisherOpt.isPresent()) {
			return publisherOpt.get();
		}
		return null;
	}

	public void deletePublisherById(Integer id) {
		publisherRepository.deleteById(id);
	}

}
