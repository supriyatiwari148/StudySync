package com.studysync.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DashboardController {

    @FXML
    private void openExams(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/fxml/exams.fxml")
            );

            Stage stage = (Stage)
                    ((javafx.scene.Node) event.getSource())
                            .getScene()
                            .getWindow();

            Scene scene = new Scene(root, 1000, 650);

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println("Could not open Exams page!");
            e.printStackTrace();
        }
    }

    @FXML
    private void openTimetable(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/fxml/timetable.fxml")
            );

            Stage stage = (Stage)
                    ((javafx.scene.Node) event.getSource())
                            .getScene()
                            .getWindow();

            Scene scene = new Scene(root, 1000, 650);

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println("Could not open Timetable page!");
            e.printStackTrace();
        }
    }

    @FXML
    private void openAssignments(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/fxml/assignments.fxml")
            );

            Stage stage = (Stage)
                    ((javafx.scene.Node) event.getSource())
                            .getScene()
                            .getWindow();

            Scene scene = new Scene(root, 1000, 650);

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println("Could not open Assignments page!");
            e.printStackTrace();
        }
    }

    @FXML
    private void openAttendance(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/fxml/attendance.fxml")
            );

            Stage stage = (Stage)
                    ((javafx.scene.Node) event.getSource())
                            .getScene()
                            .getWindow();

            Scene scene = new Scene(root, 1000, 650);

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println("Could not open Attendance page!");
            e.printStackTrace();
        }
    }

    @FXML
    private void openReminders(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/fxml/reminders.fxml")
            );

            Stage stage = (Stage)
                    ((javafx.scene.Node) event.getSource())
                            .getScene()
                            .getWindow();

            Scene scene = new Scene(root, 1000, 650);

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println("Could not open Reminders page!");
            e.printStackTrace();
        }
    }
}