package com.dominant;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.print.PrinterJob;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class analizeController {

    @FXML
    private Button backButton;

    @FXML
    private Button printButton;

    @FXML
    private PieChart paymentStatistic;

    @FXML
    private BarChart<String, Number> tenderStatistic;

    @FXML
    void initialize(){

        profitDiagramCreating();
        statusTenderDiagramCreating();

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

        printButton.setOnAction(actionEvent -> {
            PrinterJob pJ = PrinterJob.createPrinterJob();
            if(pJ != null){
                pJ.showPrintDialog(stage);
                pJ.printPage(paymentStatistic);
                pJ.endJob();
            }
        });
    }

    void profitDiagramCreating(){
        Integer profitTemp;
        String nameTemp;

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
    }

    void statusTenderDiagramCreating(){
        String statusTemp;
        int openCount = 0, closeCount = 0, loseCount = 0;

        DataBaseHandler dataBaseHandler = new DataBaseHandler();
        XYChart.Series<String, Number> dataSeries1 = new XYChart.Series<String, Number>();

        List<String> statusList = dataBaseHandler.getStatusTender();
        Iterator<String> statusListIterator = statusList.iterator();

        while (statusListIterator.hasNext()) {
            statusTemp = statusListIterator.next();
            if(statusTemp.equals("Відкритий")) {
                openCount++;
                dataSeries1.getData().add(new XYChart.Data<String, Number>(statusTemp, openCount));
            }
            if(statusTemp.equals("Закритий")) {
                closeCount++;
                dataSeries1.getData().add(new XYChart.Data<String, Number>(statusTemp, closeCount));
            }
            if(statusTemp.equals("Програний")) {
                loseCount++;
                dataSeries1.getData().add(new XYChart.Data<String, Number>(statusTemp, loseCount));
            }
        }
        tenderStatistic.getData().add(dataSeries1);
    }
}
