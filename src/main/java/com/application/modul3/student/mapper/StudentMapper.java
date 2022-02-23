package com.application.modul3.student.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.application.modul3.student.Student;
import com.application.modul3.student.dto.StudentCreateDTO;
import com.application.modul3.student.dto.StudentDTO;

@Service
public class StudentMapper {

	public Student studentCreateDTO2Student(StudentCreateDTO studentCreateDTO) {
		Student student = new Student();
		student.setName(studentCreateDTO.getName());
		student.setMail(studentCreateDTO.getMail());
		student.setPhone(studentCreateDTO.getName());
		return student;
	}

	public StudentDTO student2StudentDTO(Student student) {
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(student.getId());
		studentDTO.setName(student.getName());
		studentDTO.setMail(student.getMail());
		studentDTO.setPhone(student.getPhone());
		return studentDTO;
	}
	
	public Student studentDTO2Student(StudentDTO studentDTO) {
		Student student = new Student();
		student.setName(studentDTO.getName());
		student.setMail(studentDTO.getMail());
		student.setPhone(studentDTO.getPhone());
		return student;	
	}

	public List<StudentDTO> studentList2StudentDTOList(List<Student> students) {
		return students.stream().map(student -> student2StudentDTO(student)).collect(Collectors.toList());
	}

}
