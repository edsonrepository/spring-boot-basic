package com.example.springbootbasic.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void register(Student student) {

        Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void delete(Long id) {
        boolean existsById = studentRepository.existsById(id);
        if (!existsById) {
            throw new IllegalStateException(
                    "student with id " + id + " does not exists"
            );
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void update(Long id, String name, String email) {
        Student actualStudent = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + id + " does not exists"));
        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(actualStudent.getName(), name)) {
            actualStudent.setName(name);
        }
        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(actualStudent.getEmail(), email)) {
            actualStudent.setEmail(email);
        }

        studentRepository.save(actualStudent);

    }
}
