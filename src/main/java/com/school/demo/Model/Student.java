package com.school.demo.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private int grade;

    /**
     * student can have many classes
     * classes can have many students
     * create: join table to create student_lecture
     */

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="students_lectures",
            joinColumns={@JoinColumn(name="student_id", referencedColumnName = "id")},
            inverseJoinColumns={@JoinColumn(name="lecture_id", referencedColumnName = "id")}
    )
    private List<Lecture> lectures;

    public Student() {

    }

    public Student(String firstName, String lastName, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
