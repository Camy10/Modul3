package com.application.modul3.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.modul3.exception.ResourceNotFoundException;
import com.application.modul3.exemplary.Exemplary;
import com.application.modul3.exemplary.mapper.ExemplaryMapper;
import com.application.modul3.student.dto.StudentCreateDTO;
import com.application.modul3.student.dto.StudentDTO;
import com.application.modul3.student.mapper.StudentMapper;

@RestController
@RequestMapping("/students")
@ControllerAdvice
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentMapper studentMapper;

	@PostMapping()
	public StudentDTO createStudent(@RequestBody StudentCreateDTO studentCreateDTO) {
		Student student = studentService.createStudent(studentMapper.studentCreateDTO2Student(studentCreateDTO));
		return studentMapper.student2StudentDTO(student);
	}

	@GetMapping("/list")
	public List<StudentDTO> getAllStudent() {
		return studentMapper.studentList2StudentDTOList(studentService.getAllStudent());
	}

//	@GetMapping("/{studentId}")
//	public StudentDTO getStudentById(@PathVariable Integer studentId) {
//
//		return studentMapper.student2StudentDTO(studentService.getStudentById(studentId));
//				
//	}

	@GetMapping("/{studentId}")
	public StudentDTO getStudentById(@PathVariable Integer studentId) {
		return studentMapper.student2StudentDTO(studentService.getStudentById(studentId));
	}

	@GetMapping("/add-course/{studentId}/{courseId}")
	public void addCoursToStudent(@PathVariable Integer studentId, @PathVariable Integer courseId) {
		studentService.addCoursToStudent(studentId, courseId);
	}

	@GetMapping("/remove-course/{studentId}/{courseId}")
	public void deleteStudentAndCourse(@PathVariable Integer studentId, @PathVariable Integer courseId) {
		studentService.deleteStudentAndCourse(studentId, courseId);

	}

	@PutMapping("/{studentId}")
	public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO, @PathVariable Integer studentId) {
		Student student = studentService.updateStudent(studentMapper.studentDTO2Student(studentDTO), studentId);
		return studentMapper.student2StudentDTO(student);
	}

	@DeleteMapping("/{studentId}")
	public void deleteStudentById(@PathVariable Integer studentId) {
		studentService.deleteStudent(studentId);
	}

}
