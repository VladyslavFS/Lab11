package com.example.lab11.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController {
    public void onAddEnterpriseClick() {
        openWindow("/add_enterprise.fxml", "Add Enterprise");
    }

    public void onSearchEnterpriseClick() {
        openWindow("/search_enterprise.fxml", "Search Enterprise");
    }

    public void onUpdateEnterpriseClick() {
        openWindow("/update_enterprise.fxml", "Update Enterprise");
    }

    public void onDeleteEnterpriseClick() {
        openWindow("/delete_enterprise.fxml", "Delete Enterprise");
    }

    private void openWindow(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
