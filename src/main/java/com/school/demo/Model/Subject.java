package com.school.demo.Model;

import javax.persistence.*;

@Entity
@Table(name="subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int maxCapacity;

    @Column
    private String name;

    public Subject() {
    }

    public Subject(int id, int maxCapacity, String name) {
        this.id = id;
        this.maxCapacity = maxCapacity;
        this.name = name;
    }

    public Subject(int maxCapacity, String name) {
        this.maxCapacity = maxCapacity;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
