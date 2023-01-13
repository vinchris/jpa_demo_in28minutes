package com.in28minutes.jpa.hibernate.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    private String rating;

    private String description;

    @ManyToOne
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
