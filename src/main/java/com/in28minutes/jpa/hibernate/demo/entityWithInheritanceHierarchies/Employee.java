package com.in28minutes.jpa.hibernate.demo.entityWithInheritanceHierarchies;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // -- this will create a single table EMPLOYEE with table rows (with null values respectively) for FullTimeEmployee and PartTimeEmployee
//@DiscriminatorColumn(name = "EmployeeType") // -- default is DTYPE, the one that distinguishes between different types of extended entities
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // -- creates a table per concrete entity class, the root entity class Employee should be abstract in order to not create a useless empty table
@Inheritance(strategy = InheritanceType.JOINED) // -- A strategy in which fields that are specific to a subclass are mapped to a separate table than the fields that are common to the parent class, and a join is performed to instantiate the subclass.
public abstract class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;


    public Employee(String name) {
        this.name = name;
    }

}
