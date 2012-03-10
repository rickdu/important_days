package com.rickdu.important_day.data;

/**
 * Created by IntelliJ IDEA.
 * User: Rick
 * Date: 3/10/12
 * Time: 9:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class EventModel {
    private int id = -1;
    private String name;
    private String type;
    private int year;
    private int month;
    private int day;
    private String comment;

    public EventModel() {
    }

    public EventModel(int id, String name, String type, int year, int month, int day, String comment, String tag) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.year = year;
        this.month = month;
        this.day = day;
        this.comment = comment;
        this.tag = tag;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    private String tag;

    @Override
    public String toString() {
        return "EventModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", comment='" + comment + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
