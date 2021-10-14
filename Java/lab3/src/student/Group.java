package student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Group {
    private ArrayList<Student> students = new ArrayList<Student>();
    private String name;
    private ArrayList<LocalDate> localDates = new ArrayList<LocalDate>();

    public void addDate(LocalDate localDate){
        //Collections.sort(localDates);
        for(int i = 0; i < localDates.size(); i++){
            if(localDates.get(i).toString().equals(localDate.toString())){
                return;
            }
        }
        localDates.add(localDate);
        Collections.sort(localDates);
    }

    public ArrayList<LocalDate> getDates(){
        return localDates;
    }

    public Group(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void changeName(String name){
        this.name = name;
    }
    public String print(){
        return name;
    }
    public ArrayList<Student> getStudentList(){
        return students;
    }
    public void addStudent(String name, String surmame){
        students.add(new Student(name, surmame));
    }

}
