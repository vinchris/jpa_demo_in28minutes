package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class CourseRepository {
    @Autowired
    EntityManager em;

    //public Course findById(Long id)
    public Course findById(Long id){
        return em.find(Course.class, id);
    }

    public void deleteById(Long id){
        em.remove(findById(id));
    }


    //public Course saveCourse(Course course)
    public Course saveCourse(Course course){
        if(course.getId() == null){
            em.persist(course); // if the object exists, then update it
        }else{
            em.merge(course); // if the object doesn't exist, then add it
        }
        return course;
    }
}
