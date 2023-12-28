package com.simple_project.javaEase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simple_project.javaEase.entity.Student;

public interface StudentRepository  extends JpaRepository<Student, Integer>{
	
	Student findByRollNo(int rollNo);

}
