package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Passport;
import com.in28minutes.jpa.hibernate.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
@Slf4j
public class StudentRepository {
    @Autowired
    EntityManager em;

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    public void deleteById(Long id) {
        em.remove(findById(id));
    }

    public Student saveStudent(Student student) {
        if (student.getId() == null) {
            em.persist(student); // if the object/entity/row exists, then update it
        } else {
            em.merge(student); // if the object/entity/row doesn't exist, then add it
        }
        return student;
    }

    public void saveStudentWithPassport(){
        Passport passport = new Passport("V1234567");
        em.persist(passport); // we need to insert a new row into passport

        Student student = new Student("Vivi");
        student.setPassport(passport); // we add the OneToOne passport row reference to the new student row
        em.persist(student); // and save it
    }
}
