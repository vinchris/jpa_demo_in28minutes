package com.in28minutes.jpa.hibernate.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    private String rating;

    private String description;

    private Course course;

    public Review(String rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Review [%s %s]", rating, description);
    }
}
