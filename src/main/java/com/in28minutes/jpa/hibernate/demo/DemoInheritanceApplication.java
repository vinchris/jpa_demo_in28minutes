package com.in28minutes.jpa.hibernate.demo;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Review;
import com.in28minutes.jpa.hibernate.demo.entity.Student;
import com.in28minutes.jpa.hibernate.demo.entityWithInheritanceHierarchies.FullTimeEmployee;
import com.in28minutes.jpa.hibernate.demo.entityWithInheritanceHierarchies.PartTimeEmployee;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepository;
import com.in28minutes.jpa.hibernate.demo.repository.StudentRepository;
import com.in28minutes.jpa.hibernate.demo.repository2.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
@Slf4j
public class DemoInheritanceApplication implements CommandLineRunner {

    @Autowired
    EmployeeRepository employeeRepository;


    public static void main(String[] args) {
        SpringApplication.run(DemoInheritanceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));
        employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));

        log.info("All full-time employees ==> {}", employeeRepository.retrieveAllFullTimeEmployees());
        log.info("All part-time employees ==> {}", employeeRepository.retrieveAllPartTimeEmployees());
    }
}
