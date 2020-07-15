package com.dominant;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class analizeController {

    @FXML
    private Button backButton;

    @FXML
    private PieChart paymentStatistic;

    @FXML
    void initialize(){
        Integer profitTemp;
        String nameTemp;

        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        DataBaseHandler dataBaseHandler = new DataBaseHandler();

        List<Integer> profitList = dataBaseHandler.getProfit();
        List<String> nameList = dataBaseHandler.getName();
        Iterator<Integer> profitListIterator = profitList.iterator();
        Iterator<String> nameListIterator = nameList.iterator();

        ObservableList <PieChart.Data> profitDiagramsData = FXCollections.observableArrayList();

        while (profitListIterator.hasNext() && nameListIterator.hasNext()) {
            profitTemp = profitListIterator.next();
            nameTemp = nameListIterator.next();
            profitDiagramsData.add(new PieChart.Data(nameTemp,profitTemp));
        }
        paymentStatistic.setData(profitDiagramsData);

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
