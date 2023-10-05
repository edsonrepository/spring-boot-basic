package com.example.springbootbasic.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mirian = new Student(
                    "Miriam",
                    "mirian.teste@gmail.com",
                    LocalDate.of(2000, Month.SEPTEMBER, 5)
            );

            Student julio = new Student(
                    "Julio",
                    "julio.teste@gmail.com",
                    LocalDate.of(1990, Month.SEPTEMBER, 5)
            );

            repository.saveAll(
                    List.of(mirian, julio)
            );
        };
    }

}
