package com.in28minutes.jpa.hibernate.demo;

import com.in28minutes.jpa.hibernate.demo.entity.Review;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepository;
import com.in28minutes.jpa.hibernate.demo.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class DemoApplication implements CommandLineRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        courseRepository.addReviewsForCourse(1003L,
                Arrays.asList(new Review("4", "good and detailed"), new Review("4", "fine and detailed")));
    }
}
