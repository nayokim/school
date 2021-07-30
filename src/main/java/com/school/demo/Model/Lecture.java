package com.school.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="lectures")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String time;

    @Column
    private int maxCapacity;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name="lectures_students",
            //refer to the lecture_id column in "lectures_students" join table
            joinColumns=@JoinColumn(name="lecture_id"),
            //refer to the student_id column in "lectures_students" join table
            inverseJoinColumns=@JoinColumn(name="student_id")
    )
    private List<Student> students;


    public Lecture() {
    }

    public Lecture(long id) {
        this.id=id;
    }

    public Lecture(long id, String name, String time, int maxCapacity, List<Student> students) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.maxCapacity = maxCapacity;
        this.students = students;
    }

    public Lecture(String name, String time, int maxCapacity, List<Student> students) {
        this.name = name;
        this.time = time;
        this.maxCapacity = maxCapacity;
        this.students = students;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
