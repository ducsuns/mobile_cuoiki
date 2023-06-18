package com.example.mobile_cuoiki.model;

public class StudentClass {
    private int id;
    private int idStudent;
    private int idClass;
    private String semester;
    private int credit;

    public StudentClass() {
    }

    public StudentClass(int idStudent, int idClass, String semester, int credit) {
        this.idStudent = idStudent;
        this.idClass = idClass;
        this.semester = semester;
        this.credit = credit;
    }

    public StudentClass(int id, int idStudent, int idClass, String semester, int credit) {
        this.id = id;
        this.idStudent = idStudent;
        this.idClass = idClass;
        this.semester = semester;
        this.credit = credit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
