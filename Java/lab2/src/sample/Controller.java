package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.rmi.UnexpectedException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class Controller {
    @FXML
    private TextField boxSuma;
    @FXML
    private TextField boxTerminas;
    @FXML
    private TextField boxProcentai;
    @FXML
    private CheckBox checkAnuitetas;
    @FXML
    private CheckBox checkLinijinis;
    @FXML
    private LineChart<?, ?> lineChart;
    @FXML
    private TableView<TableInfo> table;
    @FXML
    private TableColumn<Calendar, String> columnTime;
    @FXML
    private TableColumn<TableInfo, String> columnSum, columnPercentage, columnLeft;

    //    @FXML
//    private TableColumn columnSum;
//    @FXML
//    private TableColumn columnPercetage;
//    @FXML
//    private TableColumn columnLeft;

    AnuitetoGraph anuitetoGraph = new AnuitetoGraph();
    LinijinisGraph linijinisGraph = new LinijinisGraph();

    AnuitetoTable anuitetoTable = new AnuitetoTable();
    LinijinisTable linijinisTable = new LinijinisTable();

    boolean flag = false;

    private String textSuma;
    private String textTerminas;
    private String textProcentai;

    public void pressButton(ActionEvent event) {
        textSuma = boxSuma.getText();
        //System.out.println(textSuma);
        textTerminas = boxTerminas.getText();
        //System.out.println(textTerminas);
        textProcentai = boxProcentai.getText();

        flag = true;
        try {
            double sum = Double.parseDouble(textSuma);
            int duration = Integer.parseInt(textTerminas);
            double percatage = Double.parseDouble(textProcentai);
        } catch (Exception e) {
            //System.out.println(e);
            flag = false;
        }
        if (flag) {
            double sum = Double.parseDouble(textSuma);
            int duration = Integer.parseInt(textTerminas);
            double percatage = Double.parseDouble(textProcentai);

            //columnTime = new TableColumn("String");
            columnTime.setCellValueFactory(
                    new PropertyValueFactory<>("time"));
            columnSum.setCellValueFactory(
                    new PropertyValueFactory<>("sum"));
            columnLeft.setCellValueFactory(
                    new PropertyValueFactory<>("leftSum"));
            columnPercentage.setCellValueFactory(
                    new PropertyValueFactory<>("percentage"));


            lineChart.getData().clear();
            table.getItems().clear();

            if (checkAnuitetas.isSelected()) {
                XYChart.Series seriesAnuiteto = new XYChart.Series();
                seriesAnuiteto.getData().clear();
                seriesAnuiteto = anuitetoGraph.calculate(sum, duration, percatage);

                table.getItems().addAll(anuitetoTable.calculate(sum, duration, percatage));
                //table.setItems(anuitetoTable.calculate(sum, duration, percatage));
                lineChart.getData().add(seriesAnuiteto);
            }


            if (checkLinijinis.isSelected()) {
                XYChart.Series seriesLinijinis = new XYChart.Series();
                seriesLinijinis.getData().clear();
                seriesLinijinis = linijinisGraph.calculate(sum, duration, percatage);

                table.getItems().addAll(linijinisTable.calculate(sum, duration, percatage));
                lineChart.getData().add(seriesLinijinis);
            }
        }
    }

}
