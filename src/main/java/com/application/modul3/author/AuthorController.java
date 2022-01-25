package com.application.modul3.author;

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
@RequestMapping("/authors")
public class AuthorController {
	@Autowired
	private AuthorService authorService;
	
	@PostMapping
	public Author createAuthor(@RequestBody Author author) {
		return authorService.createAuthor(author);
	}
	
	@GetMapping("/list")
	public List<Author> getAllAuthor(){
		return authorService.getAllAuthor();
	}
	
	@GetMapping("/{id}")
	public Author getAuthorById(@PathVariable Integer id) {
		return authorService.getAuthorById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAuthorById(@PathVariable Integer id) {
		authorService.deleteAuthorById(id);
	}
	
	@PutMapping("/{id}")
	public Author updateAuthor(@RequestBody Author author,@PathVariable Integer id) {
		return authorService.updateAuthorById(author, id);
	}
	
	@GetMapping("/byName")
	public Author getAtuthorByname(@RequestParam String name) {
		return authorService.getAuthorByName(name);
	}
	
	@GetMapping("/live")
	public List<Author> getAuthorWhoLive(){
		return authorService.getAuthorWhoLive();
	}

}
