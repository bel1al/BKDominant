package com.dominant;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.zip.InflaterOutputStream;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import static com.dominant.FinalVariable.*;

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
    private Label onlineUserLabel;

    ObservableList<Info> listM;
    DataBaseHandler dataBaseHandler = new DataBaseHandler();

    @FXML
    void initialize() {
        User user= new User();

        onlineUserLabel.setText(onlineUserLabel.getText() + ONLINE_USER);
        onlineUserLabel.autosize();
        //col add data from mysql
        col_id.setCellValueFactory(new PropertyValueFactory<Info,Integer>(INFO_ID));
        col_name.setCellValueFactory(new PropertyValueFactory<Info,String>(INFO_NAME));
        col_payment.setCellValueFactory(new PropertyValueFactory<Info,Integer>(INFO_PAYMENT));
        col_sum.setCellValueFactory(new PropertyValueFactory<Info,Integer>(INFO_SUM));
        col_time.setCellValueFactory(new PropertyValueFactory<Info,String>(INFO_TIME));
        col_address.setCellValueFactory(new PropertyValueFactory<Info,String>(INFO_ADDRESS));

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
    }
}
