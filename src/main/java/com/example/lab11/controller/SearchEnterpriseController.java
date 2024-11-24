package com.example.lab11.controller;

import com.example.lab11.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import com.example.lab11.Enterprise;

import java.sql.ResultSet;

public class SearchEnterpriseController {

    @FXML
    private TextField nameField;
    @FXML
    private TableView<Enterprise> tableView;
    @FXML
    private TableColumn<Enterprise, Integer> idColumn;
    @FXML
    private TableColumn<Enterprise, String> nameColumn;
    @FXML
    private TableColumn<Enterprise, String> addressColumn;
    @FXML
    private TableColumn<Enterprise, String> foundingDateColumn;
    @FXML
    private TableColumn<Enterprise, Double> fundColumn;
    @FXML
    private TableColumn<Enterprise, Double> valueColumn;

    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        foundingDateColumn.setCellValueFactory(new PropertyValueFactory<>("foundingDate"));
        fundColumn.setCellValueFactory(new PropertyValueFactory<>("fund"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
    }

    @FXML
    private void onSearchClick() {
        try {
            String name = nameField.getText();

            DatabaseHandler dbHandler = new DatabaseHandler();
            ResultSet rs = dbHandler.searchEnterprise(name);

            tableView.getItems().clear();
            while (rs.next()) {
                Enterprise enterprise = new Enterprise();
                enterprise.setId(rs.getInt("код_підприємства"));
                enterprise.setName(rs.getString("назва"));
                enterprise.setAddress(rs.getString("адреса"));
                enterprise.setFoundingDate(rs.getString("дата_заснування"));
                enterprise.setFund(rs.getDouble("статутний_фонд"));
                enterprise.setValue(rs.getDouble("балансова_вартість"));
                tableView.getItems().add(enterprise);
            }
        } catch (Exception e) {
            showAlert("Error", "Failed to search enterprise: " + e.getMessage());
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
