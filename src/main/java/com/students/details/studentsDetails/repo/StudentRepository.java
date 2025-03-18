package com.students.details.studentsDetails.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.students.details.studentsDetails.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
