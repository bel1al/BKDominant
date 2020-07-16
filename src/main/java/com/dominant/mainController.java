package com.dominant;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static com.dominant.FinalVariable.*;

public class mainController {

    @FXML
    private Button homeButton;

    @FXML
    private Button searchButton;

    @FXML
    private Button analizeButton;

    @FXML
    private TableView<Info> tableView;

    @FXML
    private TableColumn<Info, Integer> col_id;

    @FXML
    private TableColumn<Info, String> col_name;

    @FXML
    private TableColumn<Info, Integer> col_payment;

    @FXML
    private TableColumn<Info, Integer> col_sum;

    @FXML
    private TableColumn<Info, String> col_time;

    @FXML
    private TableColumn<Info, String> col_address;

    @FXML
    private TableColumn<Info, Integer> col_profit;

    @FXML
    private TableColumn<Info, String> col_status;

    @FXML
    private Label onlineUserLabel;

    ObservableList<Info> listM;
    DataBaseHandler dataBaseHandler = new DataBaseHandler();

    @FXML
    void initialize() {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();

        onlineUserLabel.setText(onlineUserLabel.getText() + ONLINE_USER);
        onlineUserLabel.autosize();
        //col add data from mysql
        col_id.setCellValueFactory(new PropertyValueFactory<Info,Integer>(INFO_ID));
        col_name.setCellValueFactory(new PropertyValueFactory<Info,String>(INFO_NAME));
        col_payment.setCellValueFactory(new PropertyValueFactory<Info,Integer>(INFO_PAYMENT));
        col_sum.setCellValueFactory(new PropertyValueFactory<Info,Integer>(INFO_SUM));
        col_time.setCellValueFactory(new PropertyValueFactory<Info,String>(INFO_TIME));
        col_address.setCellValueFactory(new PropertyValueFactory<Info,String>(INFO_ADDRESS));
        col_profit.setCellValueFactory(new PropertyValueFactory<Info,Integer>(INFO_PROFIT));
        col_status.setCellValueFactory(new PropertyValueFactory<Info,String>(INFO_STATUS));

        listM = dataBaseHandler.getInfo();
        tableView.setItems(listM);
        //end

        tableView.setVisible(false);
        searchButton.setOnAction(actionEvent -> {
            searchButton.setDisable(true);
            homeButton.setDisable(false);
            tableView.setVisible(true);
        });
        homeButton.setOnAction(actionEvent -> {
            searchButton.setDisable(false);
            homeButton.setDisable(true);
            tableView.setVisible(false);
        });

        analizeButton.setOnAction(actionEvent -> {
            analizeButton.getScene().getWindow().hide();
            loader.setLocation(getClass().getResource("analize.fxml"));

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
