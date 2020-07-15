package com.dominant;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class analizeController {

    @FXML
    private Button backButton;

    @FXML
    void initialize(){
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();

        backButton.setOnAction(actionEvent -> {
            backButton.getScene().getWindow().hide();
            loader.setLocation(getClass().getResource("main.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            stage.setScene(new Scene(root));
            stage.show();
        });
    }
}
