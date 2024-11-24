package com.example.lab11.controller;

import com.example.lab11.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Date;

public class AddEnterpriseController {

    @FXML
    private TextField nameField, addressField, foundingDateField, fundField, valueField;

    @FXML
    private void onAddClick() {
        try {
            String name = nameField.getText();
            String address = addressField.getText();
            Date foundingDate = Date.valueOf(foundingDateField.getText());
            double fund = Double.parseDouble(fundField.getText());
            double value = Double.parseDouble(valueField.getText());

            DatabaseHandler dbHandler = new DatabaseHandler();
            dbHandler.addEnterprise(name, address, foundingDate, fund, value);

            showAlert("Success", "Enterprise added successfully!");
        } catch (Exception e) {
            showAlert("Error", "Failed to add enterprise: " + e.getMessage());
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
