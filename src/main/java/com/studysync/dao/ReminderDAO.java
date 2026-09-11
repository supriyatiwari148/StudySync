package com.studysync.dao;

import com.studysync.database.DBConnection;
import com.studysync.model.Reminder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ReminderDAO {

    public List<Reminder> getAllReminders() {

        List<Reminder> reminders = new ArrayList<>();

        String query = "SELECT * FROM reminders";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(query);
                ResultSet resultSet =
                        statement.executeQuery()
        ) {

            while (resultSet.next()) {

                Reminder reminder = new Reminder();

                reminder.setReminderId(
                        resultSet.getInt("reminder_id")
                );

                reminder.setTitle(
                        resultSet.getString("title")
                );

                reminder.setDescription(
                        resultSet.getString("description")
                );

                reminder.setReminderDate(
                        resultSet.getObject(
                                "reminder_date",
                                LocalDate.class
                        )
                );

                reminder.setReminderTime(
                        resultSet.getObject(
                                "reminder_time",
                                LocalTime.class
                        )
                );

                reminder.setReminderType(
                        resultSet.getString("reminder_type")
                );

                reminder.setStatus(
                        resultSet.getString("status")
                );

                reminders.add(reminder);
            }

        } catch (Exception e) {

            System.out.println(
                    "Could not load reminders!"
            );

            e.printStackTrace();
        }

        System.out.println(
                "Total reminders found: " +
                        reminders.size()
        );

        return reminders;
    }
}