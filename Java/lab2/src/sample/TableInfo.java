package sample;

import javafx.beans.property.SimpleStringProperty;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TableInfo {

    public String  getTime() {
        return time;
    }

    public String getSum() {
        return sum;
    }

    public String getPercentage() {
        return percentage;
    }

    public String getLeftSum() {
        return leftSum;
    }

    private String  time;
    private String sum;
    private String percentage;
    private String leftSum;

    public TableInfo(String time, String sum, String percentage, String leftSum){
        this.time = time;
        this.sum = sum;
        this.percentage = percentage;
        this.leftSum = leftSum;

    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public void setLeftSum(String leftSum) {
        this.leftSum = leftSum;
    }
}
