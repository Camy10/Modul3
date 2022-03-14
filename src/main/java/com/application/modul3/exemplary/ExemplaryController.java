package com.application.modul3.exemplary;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/exemplaries")
public class ExemplaryController {

	@Autowired
	private ExemplaryService exemplaryService;

	@Autowired
	private ExemplaryMapper exemplaryMapper;


	// la exemplar creat ii add o cartea si o editura
	@PostMapping("/add/{bookId}/{publisherId}")
	public ResponseEntity<Object> createExemplary(@PathVariable Integer bookId, @PathVariable Integer publisherId,
			@RequestBody ExemplaryDTO exemplaryDTO) {
		try {
			Exemplary createExemplary = exemplaryService.createExemplary(bookId, publisherId,
					exemplaryMapper.exemplaryDTO2Exemplary(exemplaryDTO));
			return ResponseEntity.ok(exemplaryMapper.exemplary2ExemplaryDTO(createExemplary));
			// return new
			// ResponseEntity<>(exemplaryMapper.exemplary2ExemplaryDTO(createExemplary),
			// HttpStatus.OK) ;
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	// obtin toate exemplare ptr o carte ce are id =?
	@GetMapping("/list/{bookId}")
	public List<ExemplaryDTO> findExemplaryByBookId(@PathVariable Integer bookId) {
		return exemplaryMapper.exemplaryList2ExemplaryDTOlist(exemplaryService.findExemplariesByBookId(bookId));
	}
	
	@GetMapping("/list/publisher/{publisherId}")
	public List<ExemplaryDTO> findExemplaryByPublisgerId(@PathVariable Integer publisherId){
		return exemplaryMapper.exemplaryList2ExemplaryDTOlist(exemplaryService.findExemplaryByPublisherId(publisherId));
		
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
