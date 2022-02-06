package com.application.modul3.exemplary;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.modul3.exemplary.dto.ExemplaryDTO;
import com.application.modul3.exemplary.mapper.ExemplaryMapper;

@RestController
@RequestMapping("/exemplary")
public class ExemplaryController {

	@Autowired
	private ExemplaryService exemplaryService;

	@Autowired
	private ExemplaryMapper exemplaryMapper;
	// add un exemplar la editura cu id
		@PostMapping("/add-publisher/{publisherId}/{bookId}")
		public ExemplaryDTO createExemplarWhitPublisher(@PathVariable Integer publisherId, @PathVariable Integer bookId, @RequestBody ExemplaryDTO exemplaryDTO) {
			Exemplary createExemplary = exemplaryService.createExemplarWithPublisher(publisherId, bookId,
					exemplaryMapper.exemplaryDTO2Exemplary(exemplaryDTO));
			return exemplaryMapper.exemplary2ExemplaryDTO(createExemplary);
		}
	

	// add un exemplar la cartea cu id
	@PostMapping("/add/{bookId}")
	public ExemplaryDTO createExemplary(@PathVariable Integer bookId, @RequestBody ExemplaryDTO exemplaryDTO) {
		Exemplary createExemplary = exemplaryService.createExemplary(bookId,
				exemplaryMapper.exemplaryDTO2Exemplary(exemplaryDTO));
		return exemplaryMapper.exemplary2ExemplaryDTO(createExemplary);
	}

	// obtin toate exemplare ptr o carte ce are id =?
	@GetMapping("/list/{bookId}")
	public List<ExemplaryDTO> findExemplaryByBookId(@PathVariable Integer bookId) {
		return exemplaryMapper.exemplaryList2ExemplaryDTOlist(exemplaryService.findExemplariesByBookId(bookId));
	}

	@DeleteMapping("/delete/{exemplaryId}")
	public void deleteExemplary(@PathVariable Integer exemplaryId) {
		exemplaryService.deleteExemplary(exemplaryId);
	}

	// obtin toate exemplarele
	@GetMapping("/list")
	public List<ExemplaryDTO> getAllExemplary() {
		return exemplaryMapper.exemplaryList2ExemplaryDTOlist(exemplaryService.getAllExemplary());

	}

	// obtin un exemplar dupa id lui
	@GetMapping("/{id}")
	public ExemplaryDTO getExemplaryById(@PathVariable Integer id) {
		return exemplaryMapper.exemplary2ExemplaryDTO(exemplaryService.getExemplaryById(id));
	}

	// nu merge
	@PutMapping("/{id}")
	public ExemplaryDTO updateExemplary(@RequestBody Exemplary exemplary, @PathVariable Integer id) {
		return exemplaryMapper.exemplary2ExemplaryDTO(exemplaryService.updateExemplary(exemplary, id));

	}

}
