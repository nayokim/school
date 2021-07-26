package com.school.demo.Model;

import javax.persistence.*;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private int grade;

    public Student(){

    }

    public Student(int id, String name, int grade){
        this.id=id;
        this.name=name;
        this.grade=grade;
    }

    public Student(String name, int grade){
        this.name=name;
        this.grade=grade;
    }

    public Integer getId(){
        return this.id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name=name;
    }

    public Integer getGrade() {
        return this.grade;
    }

    public void setGrade(int grade){
        this.grade=grade;
    }

}
