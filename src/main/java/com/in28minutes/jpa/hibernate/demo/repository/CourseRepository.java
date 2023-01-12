package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
@Slf4j
public class CourseRepository {
    @Autowired
    EntityManager em;

    //public Course findById(Long id)
    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    public void deleteById(Long id) {
        em.remove(findById(id));
    }


    //public Course saveCourse(Course course)
    public Course saveCourse(Course course) {
        if (course.getId() == null) {
            em.persist(course); // if the object/entity/row exists, then update it
        } else {
            em.merge(course); // if the object/entity/row doesn't exist, then add it
        }
        return course;
    }

    public void playWithEntityManager() {
        log.info("play with EM - start");

        Course course1 = new Course("Web Services in 100 steps");
        em.persist(course1); // save the course1 entity object into the context/"database"
        em.flush(); // the changes are sent out to the database

        course1.setName("Web Services in 100 steps - Updated");
        em.flush();

        Course course2 = new Course("Devops in 100 steps");
        em.persist(course2); // save the course2 entity object
        em.flush();

        em.detach(course2); // the changes to course2 are no longer tracked by the entity manager
        course2.setName("Devops in 100 steps - Updated");
        em.flush();

        Course course3 = new Course("Spring in 100 steps");
        em.persist(course3); // save the course1 entity object into the context/"database"
        em.flush(); // the changes are sent out to the database

        em.clear(); // clears everything that has been tracked by the entity manager (course1 and course3, because course2 was already detached)
        course1.setName("Web Services in 100 steps - Updated - V2"); // this update will not be persisted because the tracking of course1 was cleared
        course3.setName("Spring in 100 steps - Updated"); // this update will not be persisted because the tracking of course3 was cleared/detached

        log.info("play with EM - end");
    }
}
