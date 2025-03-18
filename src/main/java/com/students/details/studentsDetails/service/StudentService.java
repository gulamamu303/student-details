package com.students.details.studentsDetails.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.students.details.studentsDetails.model.Student;
import com.students.details.studentsDetails.repo.StudentRepository;

@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository= studentRepository;
	}
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public Optional<Student> getStudentById(Long id){
		return studentRepository.findById(id);
	}
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	public void deleteStudent(Long id) {
		studentRepository.deleteById(id); ;
		
	}
    public Student updateStudent(Long id, Student studentDetails) {
        return studentRepository.findById(id)
            .map(student -> {
                student.setName(studentDetails.getName());
                student.setAge(studentDetails.getAge());
                student.setEmail(studentDetails.getEmail());
                student.setCourse(studentDetails.getCourse());
                return studentRepository.save(student);
            })
            .orElse(null);
    }
	

}
