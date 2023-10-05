package com.example.springbootbasic.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void register(@RequestBody Student student) {
        service.register(student);
    }

    @PutMapping(path = "{id}")
    public void update(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        service.update(id, name, email);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

}