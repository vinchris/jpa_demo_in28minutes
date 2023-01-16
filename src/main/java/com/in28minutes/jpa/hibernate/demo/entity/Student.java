package com.in28minutes.jpa.hibernate.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    // fetch type LAZY will trigger a LazyInitializationException due to the fact that it will end the
    // transaction before the details of student.getPassport() are retrieved
    private Passport passport;

    @ManyToMany // student entity is the owning side because it maps the relationship via the 'courses' field
    @JoinTable(name = "STUDENT_COURSE",
            joinColumns = @JoinColumn(name = "STUDENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
    // only the owning-side entity can specify the '@JoinTable'
    private List<Course> courses = new ArrayList<>();


    public Student(String name) {
        this.name = name;
    }

    protected Student() {
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    @Override
    public String toString() {
        return String.format("[%s]", name);
    }
}
