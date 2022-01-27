package com.application.modul3.exemplary;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exemplary")
public class ExemplaryController {
	
	@Autowired
	private ExemplaryService exemplaryService;
	
	@PostMapping("/add/{bookId}")
	public Exemplary createExemplary(@PathVariable Integer bookId,@RequestBody Exemplary exemplary){
		return exemplaryService.createExemplary(bookId, exemplary);	
	}

	@GetMapping("/list")
	public Set<Exemplary> getAllExemplary(){
		return exemplaryService.getAllExemplary();
	}
	
	@GetMapping("/{id}")
	public Exemplary getExemplaryById(@PathVariable Integer id) {
		return exemplaryService.getExemplaryById(id);	
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteExemplaryById(@PathVariable Integer id) {
		exemplaryService.deleteExemplaryById(id);
	}
	
	
	@PutMapping("/{id}")
	public Exemplary updateExemplary(@RequestBody Exemplary exemplary, @PathVariable Integer id) {
		return exemplaryService.updateExemplary(exemplary, id);
	}
	
	
	
}
