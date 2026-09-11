package com.studysync.dao;

import com.studysync.database.DBConnection;
import com.studysync.model.Exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ExamDAO {

    public List<Exam> getAllExams() {

        List<Exam> exams = new ArrayList<>();

        String query = "SELECT * FROM exams";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Exam exam = new Exam();

                exam.setExamId(
                        resultSet.getInt("exam_id")
                );

                exam.setSubjectId(
                        resultSet.getInt("subject_id")
                );

                exam.setExamDate(
                        resultSet.getObject("exam_date", LocalDate.class)
                );

                exam.setExamTime(
                        resultSet.getObject("exam_time", LocalTime.class)
                );

                exam.setRoom(
                        resultSet.getString("room")
                );

                exams.add(exam);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return exams;
    }
}