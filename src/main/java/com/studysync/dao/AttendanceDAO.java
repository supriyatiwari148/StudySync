package com.studysync.dao;

import com.studysync.database.DBConnection;
import com.studysync.model.Attendance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {

    public List<Attendance> getAllAttendance() {

        List<Attendance> attendanceList = new ArrayList<>();

        String query = "SELECT a.*, s.subject_name " +
                "FROM attendance a " +
                "JOIN subjects s ON a.subject_id = s.subject_id";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Attendance attendance = new Attendance();

                attendance.setAttendanceId(
                        resultSet.getInt("attendance_id")


                );
                attendance.setSubjectName(
                        resultSet.getString("subject_name")
                );

                attendance.setSubjectId(
                        resultSet.getInt("subject_id")
                );

                attendance.setTotalClasses(
                        resultSet.getInt("total_classes")
                );

                attendance.setAttendedClasses(
                        resultSet.getInt("attended_classes")
                );

                attendanceList.add(attendance);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return attendanceList;
    }
}
