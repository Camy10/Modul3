package com.application.modul3.course;

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

import com.application.modul3.course.dto.CourseCreateDTO;
import com.application.modul3.course.dto.CourseDTO;
import com.application.modul3.course.mapper.CourseMapper;

@RestController
@RequestMapping("/courses")

public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@Autowired 
	private CourseMapper courseMapper;
	
	
	@PostMapping()
	public CourseDTO createCourse(@RequestBody CourseCreateDTO courseCreateDTO) {
		Course course = courseService.createCourse(courseMapper.CourseCreateDTO2Course(courseCreateDTO));
		return courseMapper.course2CourseDTO(course);
	}
	
	@GetMapping("/list")
	public List<CourseDTO> getAllCourses(){
		return courseMapper.courseList2CourseListDTO(courseService.getAllCourses());		
	}
	
	@GetMapping("/{courseId}")
	public CourseDTO getCourseById(@PathVariable Integer courseId) {
		return courseMapper.course2CourseDTO(courseService.getCourseById(courseId)) ;
	}
	
	@PutMapping("/{courseId}")
	public CourseDTO updateCourse(@RequestBody Course course, @PathVariable Integer courseId) {
		return courseMapper.course2CourseDTO(courseService.updateCourse(course, courseId)) ;	
	}
	
	@DeleteMapping("/{courseId}")
	public void deleteCourse(@PathVariable Integer courseId) {
		courseService.deleteCourse(courseId);
	}

}
