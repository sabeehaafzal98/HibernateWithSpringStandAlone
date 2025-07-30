package com.example.HibernateWithSpringFrameWork;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "branches")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private Set<Student> students;

    public Branch(String name) {
        this.name = name;
    }

    public Branch() {
    }

    public Branch(int id, Set<Student> students, String name) {
        this.id = id;
        this.students = students;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
