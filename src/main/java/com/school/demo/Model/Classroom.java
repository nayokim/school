package com.school.demo.Model;

import javax.persistence.*;

@Entity
@Table(name="classrooms")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int capacity;

    @Column
    private String roomType;

    @Column
    private String facilities;

    public Classroom() {
    }

    public Classroom(int id, int capacity, String roomType, String facilities) {
        this.id = id;
        this.capacity = capacity;
        this.roomType = roomType;
        this.facilities = facilities;
    }

    public Classroom(int capacity, String roomType, String facilities) {
        this.capacity = capacity;
        this.roomType = roomType;
        this.facilities = facilities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }
}
