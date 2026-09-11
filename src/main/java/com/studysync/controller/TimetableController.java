package com.studysync.controller;

import com.studysync.dao.TimetableDAO;
import com.studysync.model.Timetable;

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

public class TimetableController {

    @FXML
    private HBox timetableContainer;

    @FXML
    public void initialize() {

        TimetableDAO timetableDAO = new TimetableDAO();

        List<Timetable> timetableList =
                timetableDAO.getAllTimetable();

        for (Timetable timetable : timetableList) {

            VBox card = new VBox(12);

            card.setPrefWidth(245);
            card.setPrefHeight(210);

            card.getStyleClass().add("data-card");

            // Subject name
            Label subject = new Label(
                    "📚 " + timetable.getSubjectName()
            );

            subject.getStyleClass().add("card-title");

            // Day
            Label day = new Label(
                    "📅 " + timetable.getDayOfWeek()
            );

            day.getStyleClass().add("card-info");

            // Time
            Label time = new Label(
                    "🕐 " + timetable.getStartTime()
                            + " - " + timetable.getEndTime()
            );

            time.getStyleClass().add("card-info");

            // Room
            Label room = new Label(
                    "🏫 Room: " + timetable.getRoom()
            );

            room.getStyleClass().add("card-info");

            card.getChildren().addAll(
                    subject,
                    day,
                    time,
                    room
            );

            timetableContainer
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