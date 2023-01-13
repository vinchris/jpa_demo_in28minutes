package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = DemoApplication.class)
@ExtendWith(SpringExtension.class)
@Slf4j
public class JPQLTests {

    @Autowired
    EntityManager em;

    @Test
    public void jpql_all_test() {
        TypedQuery<Course> query = em.createNamedQuery("query_get_all_courses", Course.class);
        List<Course> resultList = query.getResultList();
        log.info(" SELECT C FROM Course C -> {}", resultList);
    }

    @Test
    public void jpql_where_test() {
        TypedQuery<Course> query = em.createNamedQuery("query_get_100_steps_courses", Course.class);
        List<Course> resultList = query.setParameter("one", "%100 steps").getResultList();
        log.info(" SELECT C FROM Course C Where name like '%100 steps' -> {}", resultList);
    }
}
