package com.example.lab11.controller;

import com.example.lab11.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class DeleteEnterpriseController {

    @FXML
    private TextField idField;

    @FXML
    private void onDeleteClick() {
        try {
            int id = Integer.parseInt(idField.getText());

            DatabaseHandler dbHandler = new DatabaseHandler();
            dbHandler.deleteEnterprise(id);

            showAlert("Success", "Enterprise deleted successfully!");
        } catch (Exception e) {
            showAlert("Error", "Failed to delete enterprise: " + e.getMessage());
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
