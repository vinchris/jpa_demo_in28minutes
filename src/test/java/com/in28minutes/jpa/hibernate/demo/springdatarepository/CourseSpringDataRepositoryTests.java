package com.in28minutes.jpa.hibernate.demo.springdatarepository;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DemoApplication.class)
@ExtendWith(SpringExtension.class)
@Slf4j
public class CourseSpringDataRepositoryTests {

    @Autowired
    CourseSpringDataRepository repository;

    @Test
    public void findByIdTest() {
        Optional<Course> courseById = repository.findById(1001L);
        assertTrue(courseById.isPresent());
    }

    @Test
    public void findByWrongIdTest() {
        Optional<Course> courseById = repository.findById(1007L);
        assertFalse(courseById.isPresent());
    }

    @Test
    @Transactional
    @DirtiesContext
    public void createAndUpdateCourseTest() {
        Course course = new Course("Spring Data JPA in 100 Steps");
        repository.save(course);
        course.setName("Spring Data JPA in 100 Steps - Updated");
        repository.save(course);

        log.info("Course count: {}", repository.count());
        log.info("Courses: {}", repository.findAll());
    }

    @Test
    @Transactional
    public void sortTest() {
        log.info("Sorted courses: {}", repository.findAll(Sort.by(Sort.Direction.ASC, "name")));
    }

    @Test
    @Transactional
    public void paginationTest() {
        Page<Course> firstPage = repository.findAll(PageRequest.of(0, 3, Sort.by(Sort.Direction.ASC, "name")));
        log.info("First Page: {}", firstPage.getContent());
        Pageable secondPageable = firstPage.nextPageable();
        Page<Course> secondPage = repository.findAll(secondPageable);
        log.info("Second Page: {}", secondPage.getContent());
        Pageable thirdPageable = secondPage.nextPageable();
        Page<Course> thirdPage = repository.findAll(thirdPageable);
        log.info("Third Page: {}", thirdPage.getContent());

    }

}
