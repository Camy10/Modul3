package com.application.modul3.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;

	public Course createCourse(Course course) {
		return courseRepository.saveAndFlush(course);
	}
	
	public List<Course> getAllCourses(){
		return courseRepository.findAll();
	}
	
	public Course getCourseById(Integer courseId) {
		Optional<Course> opCourse = courseRepository.findById(courseId);
		if (opCourse.isPresent()) {
			return opCourse.get();		
		}
		return null;
	}

	public Course updateCourse(Course course, Integer courseId) {
		Course updateCourse = getCourseById(courseId);
		updateCourse.setName(course.getName());
		updateCourse.setLocation(course.getLocation());
		updateCourse.setTeacher(course.getTeacher());
		courseRepository.flush();
		return updateCourse;
	}

	public void deleteCourse(Integer courseId) {
		courseRepository.deleteById(courseId);	
	}

}
