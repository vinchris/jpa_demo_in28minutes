package com.in28minutes.jpa.hibernate.demo.queries;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@SpringBootTest(classes = DemoApplication.class)
@ExtendWith(SpringExtension.class)
@Slf4j
public class NativeQueriesTests {

    @Autowired
    EntityManager em;

    @Test
    public void native_queries_basic_test() {
        Query query = em.createNativeQuery("SELECT * FROM COURSE",Course.class);
        List resultList = query.getResultList();
        log.info(" SELECT * FROM COURSE -> {}", resultList);
    }

    @Test
    public void native_queries_where_clause_test() {
        Query query = em.createNativeQuery("SELECT * FROM COURSE WHERE ID=?",Course.class);
        query.setParameter(1,1001L); // using positional parameter(1,2,3...)
        List resultList = query.getResultList();
        log.info(" SELECT * FROM COURSE WHERE ID=1001 -> {}", resultList);
    }

    @Test
    public void native_queries_with_named_parameter_test() {
        Query query = em.createNativeQuery("SELECT * FROM COURSE WHERE ID=:id",Course.class);
        query.setParameter("id",1001L); // using named parameter
        List resultList = query.getResultList();
        log.info(" SELECT * FROM COURSE WHERE ID=1001 -> {}", resultList);
    }

    @Test
    @Transactional // this is in the boundaries of a transaction
    public void native_queries_to_update_date_all_rows_test() { // native queries can be used for mass-updates where it's counterproductive to use JPA/JPQL
        Query query = em.createNativeQuery("UPDATE COURSE set last_updated_date=CURRENT_TIMESTAMP()",Course.class);
        int nrOfRowsUpdated = query.executeUpdate();
        log.info(" UPDATE COURSE set last_updated_date=CURRENT_TIMESTAMP() -> updated rows: {}", nrOfRowsUpdated);
    }
}
