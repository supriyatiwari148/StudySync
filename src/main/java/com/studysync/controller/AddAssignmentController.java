package com.studysync.controller;

import com.studysync.dao.AssignmentDAO;
import com.studysync.model.Assignment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddAssignmentController {

    @FXML
    private TextField titleField;

    @FXML
    private TextArea descriptionField;

    @FXML
    private DatePicker dueDatePicker;

    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    public void initialize() {

        statusComboBox.getItems().addAll(
                "Pending",
                "Completed"
        );

        statusComboBox.setValue("Pending");
    }

    @FXML
    private void saveAssignment() {

        Assignment assignment = new Assignment();

        assignment.setSubjectId(1);
        assignment.setTitle(titleField.getText());
        assignment.setDescription(descriptionField.getText());
        assignment.setDueDate(dueDatePicker.getValue());
        assignment.setStatus(statusComboBox.getValue());

        AssignmentDAO assignmentDAO = new AssignmentDAO();

        boolean success = assignmentDAO.addAssignment(assignment);

        if (success) {
            System.out.println("Assignment saved successfully!");
        } else {
            System.out.println("Failed to save assignment!");
        }
    }
    @FXML
    private void backToDashboard(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/fxml/dashboard.fxml")
            );

            Stage stage = (Stage)
                    ((javafx.scene.Node) event.getSource())
                            .getScene()
                            .getWindow();

            Scene scene = new Scene(root, 1000, 650);

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println("Could not return to Dashboard!");
            e.printStackTrace();
        }
    }
}