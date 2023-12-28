package com.simple_project.javaEase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simple_project.javaEase.repository.StudentRepository;
import com.simple_project.javaEase.entity.Student;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository repo;
	
	@GetMapping("/findAll")
	public List<Student> findAll(){
		return repo.findAll();
	}
	
	@GetMapping("/findByRollNo/{rollNo}")
	public Student findByRollNo(@PathVariable int rollNo) {
		return repo.findByRollNo(rollNo);

		}
	
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student stu) {
		return repo.save(stu);
	}
	
	@PutMapping("/updateByRollNo/{rollNo}")
	public String updateStudent(@PathVariable int rollNo, @RequestBody Student stu) {
		Student stu1= repo.findByRollNo(rollNo);
		if(stu1!=null) {
			stu1.setfName(stu.getfName());
			stu1.setlName(stu.getlName());
			stu1.setMarks(stu.getMarks());
			repo.save(stu1);
			return "updated";
			
		}
		else {
			return "Not found any student to update";
		}
	}
	
	@DeleteMapping("/deleteByRollNo/{rollNo}")
	public String deleteStudent(@PathVariable int rollNo) {
		Student stu = repo.findByRollNo(rollNo);
		if(stu!=null) {
			repo.delete(stu);
			return "deleted";
		}
		else {
			return "Not found any student to delete";
		}
	}

}
