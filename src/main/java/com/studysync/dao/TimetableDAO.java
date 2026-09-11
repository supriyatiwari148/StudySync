package com.studysync.dao;

import com.studysync.database.DBConnection;
import com.studysync.model.Timetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TimetableDAO {

    public List<Timetable> getAllTimetable() {

        List<Timetable> timetableList = new ArrayList<>();

        String query = "SELECT t.*, s.subject_name " +
                "FROM timetable t " +
                "JOIN subjects s ON t.subject_id = s.subject_id";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Timetable timetable = new Timetable();

                timetable.setTimetableId(
                        resultSet.getInt("timetable_id")
                );

                timetable.setSubjectId(
                        resultSet.getInt("subject_id")
                );

                timetable.setDayOfWeek(
                        resultSet.getString("day_of_week")
                );

                timetable.setStartTime(
                        resultSet.getObject("start_time", LocalTime.class)
                );

                timetable.setEndTime(
                        resultSet.getObject("end_time", LocalTime.class)
                );

                timetable.setRoom(
                        resultSet.getString("room")
                );
                timetable.setSubjectName(
                        resultSet.getString("subject_name")
                );

                timetableList.add(timetable);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return timetableList;
    }
}