package com.dominant;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class mainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button homeButton;

    @FXML
    private Button searchButton;

    @FXML
    private TableView tableView;

    @FXML
    void initialize() {
        tableView.setVisible(false);
        searchButton.setOnAction(actionEvent -> {
            searchButton.setDisable(true);
            tableView.setVisible(true);
        });
        homeButton.setOnAction(actionEvent -> {
            searchButton.setDisable(true);
            homeButton.setDisable(false);
            tableView.setVisible(false);
        });
    }
}
