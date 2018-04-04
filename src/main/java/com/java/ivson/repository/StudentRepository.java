package com.java.ivson.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.java.ivson.domain.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

}
