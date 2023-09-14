package com.example.springbootbasic.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping(path = "/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping
    public List<Student> getStudents() {
        return service.getStudents();
    }

}