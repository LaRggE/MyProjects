package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AnuitetoTable {

    public ObservableList<TableInfo> calculate(double sum, int duration, double procentage){
        List<TableInfo> listt = new ArrayList<TableInfo>();
        ObservableList<TableInfo> list = FXCollections.observableList(listt);
        List<Double> baseNumber = new ArrayList<>();


        double wholeSum = 0;
        procentage /= 100;

        for (int i = 0;i < duration;i++) {
            double kUp = procentage * Math.pow((1 + procentage), duration);
            double kDown = Math.pow((1 + procentage), duration) - 1;
            double k = kUp / kDown * sum;
            wholeSum += k;

            baseNumber.add(k);
        }
        double leftSum = wholeSum;
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");
        cal.getTime();
        for (int i = 0;i < duration;i++) {
            cal.add(Calendar.MONTH, 1);
            leftSum -= baseNumber.get(i);
            list.add(new TableInfo(sdf.format(cal.getTime()), round(baseNumber.get(i), 2).toString(), round(baseNumber.get(i)/wholeSum*100, 2).toString(), round(leftSum, 2).toString() ));
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
