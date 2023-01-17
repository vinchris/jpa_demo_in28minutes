package com.in28minutes.jpa.hibernate.demo.entityWithInheritanceHierarchies;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// @Entity -- a mapped superclass cannot be an entity
@Data
@ToString
@NoArgsConstructor
@MappedSuperclass // -- Designates a class whose mapping information is applied to the entities that inherit from it. A mapped superclass has no separate table defined for it.
// A class designated with the MappedSuperclass annotation can be mapped in the same way as an entity except that the mappings will apply only to its subclasses since no table exists for the mapped superclass itself. When applied to the subclasses the inherited mappings will apply in the context of the subclass tables. Mapping information may be overridden in such subclasses by using the AttributeOverride and AssociationOverride annotations or corresponding XML elements.
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // -- this will create a single table EMPLOYEE with table rows (with null values respectively) for FullTimeEmployee and PartTimeEmployee
//@DiscriminatorColumn(name = "EmployeeType") // -- default is DTYPE, the one that distinguishes between different types of extended entities
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // -- creates a table per concrete entity class, the root entity class Employee should be abstract in order to not create a useless empty table
//@Inheritance(strategy = InheritanceType.JOINED) // -- A strategy in which fields that are specific to a subclass are mapped to a separate table than the fields that are common to the parent class, and a join is performed to instantiate the subclass.
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
