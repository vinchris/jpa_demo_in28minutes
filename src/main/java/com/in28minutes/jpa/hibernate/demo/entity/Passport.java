package com.in28minutes.jpa.hibernate.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Passport {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String number;

    @OneToOne(fetch = FetchType.LAZY)
    private Student student;


    public Passport(String number) {
        this.number = number;
    }

    @Override
    public String toString(){
        return String.format("Passport [%s]", number);
    }
}
