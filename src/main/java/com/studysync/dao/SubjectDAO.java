package com.studysync.dao;

import com.studysync.database.DBConnection;
import com.studysync.model.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO {

    public List<Subject> getAllSubjects() {

        List<Subject> subjects = new ArrayList<>();

        String query = "SELECT * FROM subjects";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Subject subject = new Subject();

                subject.setSubjectId(resultSet.getInt("subject_id"));
                subject.setSubjectName(resultSet.getString("subject_name"));
                subject.setSubjectCode(resultSet.getString("subject_code"));
                subject.setTeacherName(resultSet.getString("teacher_name"));
                subject.setSemester(resultSet.getInt("semester"));

                subjects.add(subject);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return subjects;
    }
}