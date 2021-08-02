package com.school.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @OneToMany(mappedBy = "teacher")
    @JsonBackReference
    private List<Lecture> lectures;


    public Teacher() {
    }

    public Teacher(long id, String firstName, String lastName, List<Lecture> lectures) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lectures = lectures;
    }

    public Teacher(String firstName, String lastName, List<Lecture> lectures) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lectures = lectures;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }
}

