package com.studysync.dao;

import com.studysync.database.DBConnection;
import com.studysync.model.Assignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AssignmentDAO {

    public List<Assignment> getAllAssignments() {

        List<Assignment> assignments = new ArrayList<>();

        String query = "SELECT * FROM assignments";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Assignment assignment = new Assignment();

                assignment.setAssignmentId(
                        resultSet.getInt("assignment_id")
                );

                assignment.setSubjectId(
                        resultSet.getInt("subject_id")
                );

                assignment.setTitle(
                        resultSet.getString("title")
                );

                assignment.setDescription(
                        resultSet.getString("description")
                );

                assignment.setDueDate(
                        resultSet.getObject("due_date", LocalDate.class)
                );

                assignment.setStatus(
                        resultSet.getString("status")
                );

                assignments.add(assignment);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return assignments;
    }
    public boolean addAssignment(Assignment assignment) {

        String query = "INSERT INTO assignments " +
                "(subject_id, title, description, due_date, status) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, assignment.getSubjectId());
            statement.setString(2, assignment.getTitle());
            statement.setString(3, assignment.getDescription());
            statement.setObject(4, assignment.getDueDate());
            statement.setString(5, assignment.getStatus());

            statement.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
