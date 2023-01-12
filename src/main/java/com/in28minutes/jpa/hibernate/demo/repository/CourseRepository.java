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

    public void playWithEntityManager1() {
        log.info("play with EM1 - start");

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

        log.info("play with EM1 - end");
    }


    public void playWithEntityManager2() {
        log.info("play with EM2 - start");

        Course course1 = new Course("Chris JPA in 100 steps");
        em.persist(course1); // save the course1 entity object into the context/"database"
        Course course2 = new Course("Chris Hibernate in 100 steps");
        em.persist(course2); // save the course2 entity object

        em.flush(); // the changes are sent out to the database

        course1.setName("Chris JPA in 100 steps - Updated");
        course2.setName("Chris Hibernate in 100 steps - Updated");

        em.refresh(course1); // refreshes the state of the instance from the database/persistence context, overwriting the previously(not-flushed) changes
        em.flush();

        log.info("play with EM2 - end");
    }

    public void playWithEntityManager3() {
        log.info("play with EM3 - start");

        Course course1 = new Course("Chris JPA in 100 steps");
        course1.setName(null); // used for testing, will fail at test runtime because we assigned NULL to a non-nullable @Column field
        em.persist(course1); // save the course1 entity object into the context/"database"


        log.info("play with EM3 - end");
    }

    public void playWithEntityManager4() {
        log.info("play with EM4 - start");
        Course course1 = new Course("Chris JPA in 100 steps");
        em.persist(course1);
        Course course2 = findById(1001L);
        course2.setName("Chris JPA in 100 steps - Updated");

        log.info("play with EM4 - end");
    }
}
