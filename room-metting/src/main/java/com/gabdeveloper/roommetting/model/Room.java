package com.gabdeveloper.roommetting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="meetingroom")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="name",nullable =false)
    private String name;
    @Column(name="date",nullable =false)
    private String date;
    @Column(name="startHour",nullable =false)
    private String startHour;
    @Column(name="endHour",nullable =false)
    private String endHour;

    public Room() {
    }

    public Room(long id, String name, String date, String endHour) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.endHour = endHour;
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
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getEndHour() {
        return endHour;
    }
    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    @Override
    public String toString() {
        return "Room [date=" + date + ", endHour=" + endHour + ", id=" + id + ", name=" + name + ", startHour="
                + startHour + "]";
    }

}