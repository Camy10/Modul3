
package com.application.modul3.student;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.application.modul3.course.Course;
import com.application.modul3.course.CourseService;
import com.application.modul3.exception.ResourceNotFoundException;


@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseService courseService;

	public Student createStudent(Student student) {
		return studentRepository.saveAndFlush(student);
	}

	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	public Student getStudentById(Integer studentId) {
		return studentRepository.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found with id " +studentId));
	}

	public Student updateStudent(Student student, Integer studentId) {
		Student updateStudent = getStudentById(studentId);
		updateStudent.setName(student.getName());
		updateStudent.setMail(student.getMail());
		updateStudent.setPhone(student.getPhone());
		studentRepository.flush();
		return updateStudent;
	}

	public void deleteStudent(Integer studentId) {
		Student student = getStudentById(studentId);
		studentRepository.delete(student);
	}

	public void addCoursToStudent(Integer studentId, Integer courseId) {
		Student student = getStudentById(studentId);
		Course course = courseService.getCourseById(courseId);
		student.addCourse(course);
		studentRepository.save(student);
	}

	public void deleteStudentAndCourse(Integer studentId, Integer courseId) {
		Student student = getStudentById(studentId);
		Course course = courseService.getCourseById(courseId);
		student.removeCourse(course);
		studentRepository.save(student);

	}
}
