package com.school.demo.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String title;

    @Column
    private String subjectTaught;

    @Column
    private int level;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Lecture> lectures;

    public Teacher() {
    }

    public Teacher(int id, String firstName, String lastName, String title, String subjectTaught, int level) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.subjectTaught = subjectTaught;
        this.level = level;
    }

    public Teacher(String firstName, String lastName, String title, String subjectTaught, int level) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.subjectTaught = subjectTaught;
        this.level = level;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubjectTaught() {
        return subjectTaught;
    }

    public void setSubjectTaught(String subjectTaught) {
        this.subjectTaught = subjectTaught;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}

