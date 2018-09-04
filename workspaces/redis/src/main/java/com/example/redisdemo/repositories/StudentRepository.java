package com.example.redisdemo.repositories;

import com.example.redisdemo.models.Student;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, String> {
}