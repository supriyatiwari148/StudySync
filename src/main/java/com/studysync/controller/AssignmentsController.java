package com.studysync.controller;

import com.studysync.dao.AssignmentDAO;
import com.studysync.model.Assignment;

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

public class AssignmentsController {

    @FXML
    private HBox assignmentContainer;

    @FXML
    public void initialize() {

        AssignmentDAO assignmentDAO = new AssignmentDAO();

        List<Assignment> assignments =
                assignmentDAO.getAllAssignments();

        for (Assignment assignment : assignments) {

            VBox card = new VBox(12);

            card.setPrefWidth(250);
            card.setPrefHeight(220);

            card.getStyleClass().add("data-card");

            // Assignment title
            Label title = new Label(
                    "📚 " + assignment.getTitle()
            );

            title.setWrapText(true);
            title.getStyleClass().add("card-title");

            // Description
            Label description = new Label(
                    assignment.getDescription()
            );

            description.setWrapText(true);
            description.getStyleClass().add("card-secondary");

            // Due date
            Label dueDate = new Label(
                    "📅 Due: " + assignment.getDueDate()
            );

            dueDate.getStyleClass().add("card-info");

            // Status
            Label status = new Label(
                    "✓ Status: " + assignment.getStatus()
            );

            status.getStyleClass().add("card-info");

            card.getChildren().addAll(
                    title,
                    description,
                    dueDate,
                    status
            );

            assignmentContainer
                    .getChildren()
                    .add(card);
        }
    }

    @FXML
    private void addAssignment() {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource(
                                    "/fxml/add-assignment.fxml"
                            )
                    );

            Parent root = loader.load();

            Stage stage = new Stage();

            stage.setTitle("Add Assignment");

            stage.setScene(
                    new Scene(root, 500, 600)
            );

            stage.centerOnScreen();
            stage.show();

        } catch (Exception e) {

            System.out.println(
                    "Could not open Add Assignment form!"
            );

            e.printStackTrace();
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