package com.studysync.model;

public class Student {

    private int studentId;
    private String name;
    private String email;
    private String course;
    private int semester;

    public Student() {
    }

    public Student(int studentId, String name, String email,
                   String course, int semester) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.course = course;
        this.semester = semester;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}