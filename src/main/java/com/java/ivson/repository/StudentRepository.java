package com.java.ivson.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.java.ivson.domain.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

	public List<Student> findByNameLikeIgnoreCase(String name);
}
