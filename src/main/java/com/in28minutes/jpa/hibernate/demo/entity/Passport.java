package com.in28minutes.jpa.hibernate.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This entity has a bidirectional @OneToOne relationship with the Student entity.
 * The Student entity is the owning (side) entity
 */
@Entity
@Data
@NoArgsConstructor
public class Passport {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String number;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport") // mapped by the field in Student Entity,
    // and by this mapping, it's indicated that Passport Entity is the non-owning side of the relationship.
    // This is done to ensure a bidirectional relationship without duplication of information (being stored
    // in two different locations)
    private Student student;


    public Passport(String number) {
        this.number = number;
    }

    @Override
    public String toString(){
        return String.format("Passport [%s]", number);
    }
}
