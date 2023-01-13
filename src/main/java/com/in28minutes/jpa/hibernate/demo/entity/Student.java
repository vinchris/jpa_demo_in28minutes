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
