package com.studysync.controller;

import com.studysync.dao.AttendanceDAO;
import com.studysync.model.Attendance;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class AttendanceController {

    @FXML
    private HBox attendanceContainer;

    @FXML
    public void initialize() {

        AttendanceDAO attendanceDAO =
                new AttendanceDAO();

        List<Attendance> attendanceList =
                attendanceDAO.getAllAttendance();

        for (Attendance attendance : attendanceList) {

            VBox card = new VBox(12);

            card.setPrefWidth(250);
            card.setPrefHeight(220);

            card.getStyleClass().add("data-card");

            // Subject name
            Label subject = new Label(
                    "📚 " + attendance.getSubjectName()
            );

            subject.setWrapText(true);
            subject.getStyleClass().add("card-title");

            // Subject ID
            Label subjectId = new Label(
                    "Subject ID: " +
                            attendance.getSubjectId()
            );

            subjectId.getStyleClass().add("card-secondary");

            // Total classes
            Label total = new Label(
                    "📖 Total Classes: " +
                            attendance.getTotalClasses()
            );

            total.getStyleClass().add("card-info");

            // Attended classes
            Label attended = new Label(
                    "✅ Attended: " +
                            attendance.getAttendedClasses()
            );

            attended.getStyleClass().add("card-info");

            // Attendance percentage
            double percentage =
                    attendance.getAttendancePercentage();

            Label percentageLabel = new Label(
                    String.format(
                            "📊 Attendance: %.1f%%",
                            percentage
                    )
            );

            percentageLabel.getStyleClass().add("card-title");

            card.getChildren().addAll(
                    subject,
                    subjectId,
                    total,
                    attended,
                    percentageLabel
            );

            attendanceContainer
                    .getChildren()
                    .add(card);
        }
    }

    @FXML
    private void backToDashboard(ActionEvent event) {

        try {

            Parent root = FXMLLoader.load(
                    getClass().getResource(
                            "/fxml/dashboard.fxml"
                    )
            );

            Stage stage = (Stage)
                    ((javafx.scene.Node) event.getSource())
                            .getScene()
                            .getWindow();

            Scene scene = new Scene(
                    root,
                    1000,
                    650
            );

            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();

        } catch (Exception e) {

            System.out.println(
                    "Could not return to Dashboard!"
            );

            e.printStackTrace();
        }
    }
}