package com.students.details.studentsDetails.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.students.details.studentsDetails.model.Student;
import com.students.details.studentsDetails.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService= studentService;
	}
	@GetMapping
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id){
		return studentService.getStudentById(id).map(ResponseEntity::ok).orElse(null);
//		Optional<Student> studentById = studentService.getStudentById(id);
//		 if (studentById != null) {
//		        return ResponseEntity.ok(studentById);
//		    } else {
//		        return ResponseEntity.notFound().build();
//		    }
	}
	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		return ResponseEntity.ok(studentService.createStudent(student));
	}
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id,@RequestBody Student studentDetails) {
        Student updatedStudent = studentService.updateStudent(id, studentDetails);
        return updatedStudent != null ? ResponseEntity.ok(updatedStudent) : ResponseEntity.notFound().build();
    }
	
}

