package com.in28minutes.jpa.hibernate.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(fetch = FetchType.LAZY) // fetch type LAZY will trigger a LazyInitializationException due to the fact that it will end the transaction before the details of student.getPassport() are retrieved
    private Passport passport;


    public Student(String name) {
        this.name = name;
    }

    protected Student() {
    }

    @Override
    public String toString(){
        return String.format("Student [%s]", name);
    }
}
