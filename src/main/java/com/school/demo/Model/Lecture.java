package com.school.demo.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="lectures")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String time;

    @Column
    private int maxCapacity;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    @ManyToMany(mappedBy="lectures")
    private List<Student> students;

    public Lecture() {
    }

    public Lecture(int id, String name, String time, int maxCapacity) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.maxCapacity = maxCapacity;
    }

    public Lecture(String name, String time, int maxCapacity, Teacher teacher) {
        this.name = name;
        this.time = time;
        this.maxCapacity = maxCapacity;
        this.teacher = teacher;
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

    public String getTime() {
        return this.time;
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

    public Teacher getTeacher(){
        return this.teacher;
    }

    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }
}
