package com.example.redisdemo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.redisdemo.models.Student;
import com.example.redisdemo.repositories.StudentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    public static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Student>> listStudents() {
        Iterable<Student> students = studentRepository.findAll();
        List<Student> studentList = new ArrayList<Student>();
        students.forEach(student -> {
            studentList.add(student);
        });
        if(studentList.isEmpty()) {
            logger.error("No students found.");
            return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
        }
    }

    @RequestMapping(method=RequestMethod.GET, value="/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") String id) {
        logger.info("Get student by id {}.", id);
        Student student = studentRepository.findOne(id);
        if(student == null) {
            logger.error("Student by id {} not found.", id);
            return new ResponseEntity<String>("Student with id " + id + " not found.", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        }
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return new ResponseEntity<String>(student.getId(), HttpStatus.CREATED);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable("id") String id, @RequestBody Student student) {
        Student foundStudent = studentRepository.findOne(id);
        if(foundStudent == null) {
            logger.error("Student by id {} not found.", id);
            return new ResponseEntity<String>("Student with id " + id + " not found.", HttpStatus.NOT_FOUND);
        } else {
            foundStudent.setName(student.getName());
            foundStudent.setGender(student.getGender());
            foundStudent.setGrade(student.getGrade());
            studentRepository.save(student);
            return new ResponseEntity<String>(foundStudent.getId(), HttpStatus.OK);
        }
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") String id) {
        studentRepository.delete(id);
        return new ResponseEntity<String>(id, HttpStatus.OK);
    }

} 