package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class LinijinisTable {

    double sum;

    public ObservableList<TableInfo> calculate(double sum, int duration, double procentage){
        List<TableInfo> listt = new ArrayList<TableInfo>();
        ObservableList<TableInfo> list = FXCollections.observableList(listt);

        List<Double> baseNumber = new ArrayList<>();

        this.sum = sum/duration;
        double wholeSum = 0;
        procentage /= 100;

        for (int i = 0;i < duration;i++){

            double proSum = sum * procentage;
            double k = this.sum + proSum;
            //k = Math.round(k);
            //round()
            sum -=this.sum;
            wholeSum += k;
           // k = round(k, 2);

            baseNumber.add(k);

            //list.add(new TableInfo(i, k, wholeSum/k *100, sum - proSum));
        }
        this.sum = wholeSum;
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");
        cal.getTime();
        for (int i = 0;i < duration;i++){
            this.sum -= baseNumber.get(i);
            cal.add(Calendar.MONTH,1);
            if(i + 1 == duration){
                list.add(new TableInfo(sdf.format(cal.getTime()), round(baseNumber.get(i), 2).toString(), round(baseNumber.get(i) *100/wholeSum, 2).toString(), "0"));
            }
            else list.add(new TableInfo(sdf.format(cal.getTime()), round(baseNumber.get(i), 2).toString(), round(baseNumber.get(i) *100/wholeSum, 2).toString(), round(this.sum, 2).toString()));
        }


        //System.out.println(list.size());
        return list;
    }
    public static BigDecimal round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd;
    }
}
