package com.java.ivson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.ivson.domain.Student;
import com.java.ivson.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
	//@GetMapping(value="/students")
	@RequestMapping(value = "/students", method=RequestMethod.GET)
	public List<Student> listStudent() {
		return studentRepository.findAll();
	}
	
	//@PostMapping
	@RequestMapping(value = "/student", method=RequestMethod.POST)
	public Student save(@RequestBody Student student) {
		return this.studentRepository.save(student);
	}
}
