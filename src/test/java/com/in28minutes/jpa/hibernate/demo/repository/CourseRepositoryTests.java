package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
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

    @Autowired
    EntityManager entityManager;

    @Test
    public void findById_basic_test(){
        Course course = courseRepository.findById(1001L);
        assertEquals("JPA in 50 steps",course.getName());
        log.info("TEST COMPLETED!!!!");
    }

    @Test
    @Transactional
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

    @DirtiesContext
    @Test
    public void playWithEntityManager1(){
        courseRepository.playWithEntityManager1();
    }

    @DirtiesContext
    @Test
    @Disabled // disabled because this test method will always fail due to assigning NULL to a non-nullable @Column field
    public void playWithEntityManager3(){
        courseRepository.playWithEntityManager3();
    }

    @Test
    @Transactional
    public void retrieveReviewsFromCourse(){

        Course course = courseRepository.findById(1003L);
        log.info("Reviews for this course are: " + course.getReviews());
    }

    @Test
    @Transactional
    public void retrieveCourseFromReview(){

        Review review = entityManager.find(Review.class, 5001L);
        log.info("Course assigned to this review is: " + review.getCourse());
    }
}
