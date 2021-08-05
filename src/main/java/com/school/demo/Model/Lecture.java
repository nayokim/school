package com.school.demo.Model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="lectures")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String time;

    @Column
    private int maxCapacity;

    @ManyToOne
    @JoinColumn (name="teacher_id")
    private Teacher teacher;

    @ManyToMany(fetch =FetchType.EAGER)
    @JsonIgnore
    @JoinTable(
            name="lectures_students",
            //refer to the lecture_id column in "lectures_students" join table
            joinColumns=@JoinColumn(name="lecture_id"),
            //refer to the student_id column in "lectures_students" join table
            inverseJoinColumns=@JoinColumn(name="student_id")
    )
    private Set<Student> students = new HashSet<>();


    public Lecture() {
    }

    public Lecture(long id){
        this.id=id;
    }

    public Lecture(Long id, String name, String time, int maxCapacity, Teacher teacher, Set<Student> students) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.maxCapacity = maxCapacity;
        this.teacher = teacher;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Teacher getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
