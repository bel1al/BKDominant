package com.dominant;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button loginButton;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    void initialize() {
        Alert a = new Alert(Alert.AlertType.NONE);
        loginButton.setOnAction(actionEvent -> {
            if(loginField.getText().equals("admin") && passwordField.getText().equals("admin")) {
                loginButton.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();

                loader.setLocation(getClass().getResource("main.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();

            }else{
                a.setAlertType(Alert.AlertType.ERROR);
                a.setContentText("Не вірний логін або пароль");
                a.show();
            }
        });
    }
}
