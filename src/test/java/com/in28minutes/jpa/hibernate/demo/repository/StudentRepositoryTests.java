package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Passport;
import com.in28minutes.jpa.hibernate.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = DemoApplication.class)
@ExtendWith(SpringExtension.class)
@Slf4j
public class StudentRepositoryTests {

    @Autowired
    EntityManager em;

    /**
     * We are extending the transaction for the entire test not just the retrieval of the student entity
     * so we can lazily fetch the passport details also
     */
    @Test
    @Transactional
    //
    public void retrieveStudentAndPassportDetailsTest() {
        Student student = em.find(Student.class, 2001L);
        log.info("Student details: {}", student);
        log.info("Passport details: {}", student.getPassport());
    }

    /**
     * We are interacting with the persistence context via the entity manager.
     * We are extending the transaction with @Transactional for the entire test,
     * not just the retrieval of the student entity, so we can lazily fetch the passport details also
     * AND to also ROLLBACK any changes in case one operation fails
     *
     * P.S.: As soon as you define a transaction, you also create a persistence context,
     * where all the entities you are operating upon are stored inside. The persistence context is created at the start
     * of the transaction and killed at the end of the transaction.
     */
    @Test
    @Transactional
    public void retrieveStudentAndPassportDetailsAndUpdatePassportDetailsTest() {

        // retrieve student
        Student student = em.find(Student.class, 2001L);
        log.info("Student details: {}", student);
        // persistence context contains the student entity

        // retrieve passport
        Passport studentPassport = student.getPassport();
        log.info("Passport details: {}", studentPassport);
        // persistence context contains the student and the studentPassport entities

        // update passport
        studentPassport.setNumber("E1234567");

        //update student
        student.setName("Cristian - Updated");

    }

    @Test
    @Transactional
    //
    public void retrievePassportAndAssociatedStudentTest() {
        Passport passport = em.find(Passport.class, 4001L);
        log.info("Passport: {}", passport);
        log.info("Student details: {}", passport.getStudent());
    }

}
