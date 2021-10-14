package student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Student {
    private String name, surname;
    private ArrayList<LocalDate> localDates = new ArrayList<LocalDate>();
    private LocalDate localDate;

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public void addDate(LocalDate localDate){
        for(int i = 0; i < localDates.size(); i++){
            if(localDates.get(i).toString().equals(localDate.toString())){
                return;
            }
        }
        localDates.add(localDate);
        Collections.sort(localDates);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setLocalDates(ArrayList<LocalDate> localDates) {
        this.localDates = localDates;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public ArrayList<LocalDate> getLocalDates() {
        return localDates;
    }

    public ArrayList<LocalDate> getDates(){
        return localDates;
    }
    public Student(String name, String surname){
        this.name = name;
        this.surname = surname;
    }
    public Student(LocalDate localDate, String name, String surname){
        this.name = name;
        this.surname = surname;
        this.localDate = localDate;
    }
    public void changeName(String name, String surname){
        this.name = name;
        this.surname = surname;
    }
    public void changeDate(LocalDate date, int number){
        localDates.set(number, localDate);
    }
    public String print(){
        String temp = name;
        temp += " ";
        temp += surname;
        return temp;
    }
}
