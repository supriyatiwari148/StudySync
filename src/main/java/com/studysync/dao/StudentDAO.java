package com.studysync.dao;

import com.studysync.database.DBConnection;
import com.studysync.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        String query = "SELECT * FROM students";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Student student = new Student();

                student.setStudentId(
                        resultSet.getInt("student_id")
                );

                student.setName(
                        resultSet.getString("name")
                );

                student.setEmail(
                        resultSet.getString("email")
                );

                student.setCourse(
                        resultSet.getString("course")
                );

                student.setSemester(
                        resultSet.getInt("semester")
                );

                students.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }
}