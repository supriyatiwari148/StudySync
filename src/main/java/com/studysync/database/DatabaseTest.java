package com.studysync.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseTest {

    public static void main(String[] args) {

        String query = "SELECT * FROM subjects";

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("\n--- Subjects in StudySync ---");

            while (resultSet.next()) {

                int id = resultSet.getInt("subject_id");
                String name = resultSet.getString("subject_name");
                String code = resultSet.getString("subject_code");
                String teacher = resultSet.getString("teacher_name");

                System.out.println(
                        id + " | " +
                                name + " | " +
                                code + " | " +
                                teacher
                );
            }

        } catch (Exception e) {
            System.out.println("Error while reading database!");
            e.printStackTrace();
        }
    }
}