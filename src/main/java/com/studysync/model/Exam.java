package com.studysync.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Exam {

    private int examId;
    private int subjectId;
    private LocalDate examDate;
    private LocalTime examTime;
    private String room;

    public Exam() {
    }

    public Exam(int examId, int subjectId, LocalDate examDate,
                LocalTime examTime, String room) {
        this.examId = examId;
        this.subjectId = subjectId;
        this.examDate = examDate;
        this.examTime = examTime;
        this.room = room;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public LocalTime getExamTime() {
        return examTime;
    }

    public void setExamTime(LocalTime examTime) {
        this.examTime = examTime;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}