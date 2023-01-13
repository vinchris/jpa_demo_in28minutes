package com.in28minutes.jpa.hibernate.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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


    public Passport(String number) {
        this.number = number;
    }

    @Override
    public String toString(){
        return String.format("Passport [%s]", number);
    }
}
