package com.in28minutes.jpa.hibernate.demo.repository2;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Review;
import com.in28minutes.jpa.hibernate.demo.entityWithInheritanceHierarchies.Employee;
import com.in28minutes.jpa.hibernate.demo.entityWithInheritanceHierarchies.FullTimeEmployee;
import com.in28minutes.jpa.hibernate.demo.entityWithInheritanceHierarchies.PartTimeEmployee;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Transactional
@Slf4j
public class EmployeeRepository {
    @Autowired
    EntityManager em;

    public void insert(Employee employee) {
        em.persist(employee);
    }

    public List<Employee> retrieveAllEmployees() {
        return em.createQuery("select e from Employee e", Employee.class).getResultList(); // this will not work if Employee is a @MappedSuperclass
    }

    public List<PartTimeEmployee> retrieveAllPartTimeEmployees() {
        return em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList(); // retrieve all PartTimeEmployee rows
    }

    public List<FullTimeEmployee> retrieveAllFullTimeEmployees() {
        return em.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList(); // retrieve all FullTimeEmployee rows
    }

}
