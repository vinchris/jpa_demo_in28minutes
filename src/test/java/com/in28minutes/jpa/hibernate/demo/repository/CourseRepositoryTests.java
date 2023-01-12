package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = DemoApplication.class)
@ExtendWith(SpringExtension.class)
@Slf4j
public class CourseRepositoryTests {

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void findById_basic_test(){
        Course course = courseRepository.findById(1001L);
        assertEquals("JPA in 50 steps",course.getName());
        log.info("TEST COMPLETED!!!!");
    }

    @Test
    @DirtiesContext
    public void deleteById_test(){
        courseRepository.deleteById(1001L);
        assertNull(courseRepository.findById(1001L));

    }

    @DirtiesContext
    @Test
    public void save_basic(){
        // get a courser and update the details
        Course course = courseRepository.findById(1001L);
        assertEquals("JPA in 50 steps",course.getName());

        String newCourseName = "JPA in 50 steps - Updated";
        course.setName(newCourseName);
        courseRepository.saveCourse(course);

        assertEquals(newCourseName,course.getName());
        assertEquals(newCourseName,courseRepository.findById(1001L).getName());
    }
}
