package com.studysync.controller;

import com.studysync.dao.ExamDAO;
import com.studysync.model.Exam;

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

public class ExamsController {

    @FXML
    private HBox examContainer;

    @FXML
    public void initialize() {

        ExamDAO examDAO = new ExamDAO();

        List<Exam> exams = examDAO.getAllExams();

        for (Exam exam : exams) {

            VBox card = new VBox(12);

            card.setPrefWidth(245);
            card.setPrefHeight(210);

            card.getStyleClass().add("data-card");

            // Exam title
            Label title = new Label(
                    "📝 Exam ID: " + exam.getExamId()
            );

            title.getStyleClass().add("card-title");

            // Exam date
            Label date = new Label(
                    "📅 Date: " + exam.getExamDate()
            );

            date.getStyleClass().add("card-info");

            // Exam time
            Label time = new Label(
                    "🕐 Time: " + exam.getExamTime()
            );

            time.getStyleClass().add("card-info");

            // Exam room
            Label room = new Label(
                    "🏫 Room: " + exam.getRoom()
            );

            room.getStyleClass().add("card-info");

            card.getChildren().addAll(
                    title,
                    date,
                    time,
                    room
            );

            examContainer.getChildren().add(card);
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