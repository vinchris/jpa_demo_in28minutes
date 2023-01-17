package com.in28minutes.jpa.hibernate.demo.springdatarepository;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * JpaRepository = JPA specific extension of org.springframework.data.repository.Repository.
 */
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {

}
