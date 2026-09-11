package com.studysync.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reminder {

    private int reminderId;
    private String title;
    private String description;
    private LocalDate reminderDate;
    private LocalTime reminderTime;
    private String reminderType;
    private String status;

    public Reminder() {
    }

    public Reminder(int reminderId, String title, String description,
                    LocalDate reminderDate, LocalTime reminderTime,
                    String reminderType, String status) {
        this.reminderId = reminderId;
        this.title = title;
        this.description = description;
        this.reminderDate = reminderDate;
        this.reminderTime = reminderTime;
        this.reminderType = reminderType;
        this.status = status;
    }

    public int getReminderId() {
        return reminderId;
    }

    public void setReminderId(int reminderId) {
        this.reminderId = reminderId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(LocalDate reminderDate) {
        this.reminderDate = reminderDate;
    }

    public LocalTime getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(LocalTime reminderTime) {
        this.reminderTime = reminderTime;
    }

    public String getReminderType() {
        return reminderType;
    }

    public void setReminderType(String reminderType) {
        this.reminderType = reminderType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
