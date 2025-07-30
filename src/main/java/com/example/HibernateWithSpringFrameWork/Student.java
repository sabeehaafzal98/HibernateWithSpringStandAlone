package com.example.HibernateWithSpringFrameWork;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses;

    public Student() {
    }

    public Student(int id, String name, String email, University university, Branch branch, Set<Course> courses) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.university = university;
        this.branch = branch;
        this.courses = courses;
    }


}


