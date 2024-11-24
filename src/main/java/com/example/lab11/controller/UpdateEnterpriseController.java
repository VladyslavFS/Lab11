package com.example.lab11.controller;

import com.example.lab11.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class UpdateEnterpriseController {

    @FXML
    private TextField idField, addressField, valueField;

    @FXML
    private void onUpdateClick() {
        try {
            int id = Integer.parseInt(idField.getText());
            String address = addressField.getText();
            double value = Double.parseDouble(valueField.getText());

            DatabaseHandler dbHandler = new DatabaseHandler();
            dbHandler.updateEnterprise(id, address, value);

            showAlert("Success", "Enterprise updated successfully!");
        } catch (Exception e) {
            showAlert("Error", "Failed to update enterprise: " + e.getMessage());
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
