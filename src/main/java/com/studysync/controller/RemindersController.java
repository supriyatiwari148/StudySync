package com.studysync.controller;

import com.studysync.dao.ReminderDAO;
import com.studysync.model.Reminder;

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

public class RemindersController {

    @FXML
    private HBox reminderContainer;

    @FXML
    public void initialize() {

        ReminderDAO reminderDAO = new ReminderDAO();

        List<Reminder> reminders =
                reminderDAO.getAllReminders();

        for (Reminder reminder : reminders) {

            VBox card = new VBox(12);

            card.setPrefWidth(270);
            card.setPrefHeight(230);

            card.getStyleClass().add("data-card");

            // Reminder title
            Label title = new Label(
                    "🔔 " + reminder.getTitle()
            );

            title.setWrapText(true);
            title.getStyleClass().add("card-title");

            // Reminder type
            Label type = new Label(
                    "📌 Type: " + reminder.getReminderType()
            );

            type.getStyleClass().add("card-secondary");

            // Description
            Label description = new Label(
                    reminder.getDescription()
            );

            description.setWrapText(true);
            description.getStyleClass().add("card-info");

            // Date
            Label date = new Label(
                    "📅 Date: " + reminder.getReminderDate()
            );

            date.getStyleClass().add("card-info");

            // Time
            Label time = new Label(
                    "🕐 Time: " + reminder.getReminderTime()
            );

            time.getStyleClass().add("card-info");

            // Status
            Label status = new Label(
                    "✓ Status: " + reminder.getStatus()
            );

            status.getStyleClass().add("card-info");

            card.getChildren().addAll(
                    title,
                    type,
                    description,
                    date,
                    time,
                    status
            );

            reminderContainer
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