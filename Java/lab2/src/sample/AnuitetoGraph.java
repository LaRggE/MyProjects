package sample;

import javafx.fxml.FXML;
import javafx.scene.chart.XYChart;

public class AnuitetoGraph extends Graph{

    XYChart.Series calculate(double sum, int duration, double procentage){
        XYChart.Series series = new XYChart.Series();

        procentage /= 100;
        for(int i = 1; i <= duration; i++){
            //System.out.println("sdddddd");
            double kUp = procentage * Math.pow((1 + procentage), duration);
            double kDown = Math.pow((1 + procentage), duration) - 1;
            double k = kUp / kDown * sum;

            series.getData().add(new XYChart.Data(i, k));
            //System.out.println(i + " " + k);
        }
        series.setName("Anuiteto");
        return series;
    }
}
