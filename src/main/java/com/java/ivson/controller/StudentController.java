package com.java.ivson.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/students", method=RequestMethod.GET)
	public List<Student> listStudent() {
		return studentRepository.findAll();
	}
	
	@RequestMapping(value = "/student", method=RequestMethod.POST)
	public Student save(@RequestBody Student student) {
		return this.studentRepository.save(student);
	}
	
	@RequestMapping(value = "/student/{id}", method=RequestMethod.GET)
	public Student findById(@PathVariable String id) {
		Optional<Student> student = studentRepository.findById(id);
		return student.orElseThrow(() -> new IllegalArgumentException("Objeto nao encontrado"));
	}
	
	@RequestMapping(value = "/student/{name}/name", method=RequestMethod.GET)
	public List<Student> findByName(@PathVariable String name) {
		return studentRepository.findByNameLikeIgnoreCase(name);
	}
	
}
