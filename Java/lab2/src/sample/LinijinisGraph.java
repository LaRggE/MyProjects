package sample;

import javafx.scene.chart.XYChart;

public class LinijinisGraph extends Graph{

    double sum;

    XYChart.Series calculate(double sum, int duration, double procentage){
        XYChart.Series series = new XYChart.Series();
        this.sum = sum / duration;
        procentage /= 100;

        for(int i = 1; i <= duration; i++){
           // System.out.println("sdddddd");
            double proSum = sum * procentage;
            double k = this.sum + proSum;
            sum -=this.sum;

            series.getData().add(new XYChart.Data(i, k));
            //System.out.println(i + " " + k);
        }
        series.setName("Linijinis");

        return series;
    }

}
