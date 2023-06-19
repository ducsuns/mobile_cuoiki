package com.example.mobile_cuoiki.model;

public class Student {
    private  int id;
    private String name;
    private  String dob;
    private String hometown;
    private String schoolyear;

    public Student() {
    }

    public Student(int id, String name, String dob, String hometown, String schoolyear) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.hometown = hometown;
        this.schoolyear = schoolyear;
    }

    public Student(String name, String dob, String hometown, String schoolyear) {
        this.name = name;
        this.dob = dob;
        this.hometown = hometown;
        this.schoolyear = schoolyear;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getSchoolyear() {
        return schoolyear;
    }

    public void setSchoolyear(String schoolyear) {
        this.schoolyear = schoolyear;
    }

    @Override
    public String toString() {
        return "ID: " + id +"\n"+ "Họ và tên : "+name+"\n"+"Năm sinh: "+dob+"\n"+"Quê quán : "+hometown+"\n"+"Năm học: "+schoolyear;
    }
}
