package student.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import student.Group;
import student.Main;
import student.Student;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ModifyController {
    @FXML
    private Button deleteGroupButton;

    @FXML
    private ChoiceBox<String> dateChoiceBox;

    @FXML
    private ChoiceBox<String> groupChoiceBox;

    @FXML
    private Button deleteStudentButton;

    @FXML
    private Button changeDate;

    @FXML
    private ChoiceBox<String> studentChoiceBox;

    @FXML
    private Button changeGroupNameButton;

    @FXML
    private Button changeStudentNameButton;

    @FXML
    private TextField groupTextField;

    @FXML
    private TextField studentNameTextField;

    @FXML
    private TextField studentSurnameTextField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button deleteDate;

    ObservableList<Group> groupList;

    private int saveGroup = -1;
    private int saveStudent = -1;
    private int saveDate = -1;

    @FXML
    private void initialize(){
        groupList = Main.getGroupList();
        groupChoiceBox.getItems().clear();
        for(int i = 0; i < groupList.size(); i++) {
            groupChoiceBox.getItems().add(groupList.get(i).getName());
        }
    }
    @FXML
    private void loadStudents(){
        saveStudent = -1;
        saveDate = -1;
        for(int i = 0; i < groupList.size(); i++){
            if(groupList.get(i).getName().equals(groupChoiceBox.getValue())){
                saveGroup = i;
                break;
            }
        }
        System.out.println("modifyController");
        System.out.println(saveGroup);
        studentChoiceBox.getItems().clear();
        if(saveGroup != -1) {
            for (int j = 0; j < groupList.get(saveGroup).getStudentList().size(); j++) {
                studentChoiceBox.getItems().add(groupList.get(saveGroup).getStudentList().get(j).print());
            }
        }
    }

    @FXML
    private void loadDates(){
         for(int i = 0; i < groupList.get(saveGroup).getStudentList().size();i++){
             if(groupList.get(saveGroup).getStudentList().get(i).print().equals(
                     studentChoiceBox.getValue())){
                 saveStudent = i;
                 break;
             }
         }
         dateChoiceBox.getItems().clear();
         System.out.println("loadDate" + saveGroup + " " + saveStudent);
         if(saveStudent != -1) {
             for (int i = 0; i < groupList.get(saveGroup).getStudentList().get(saveStudent).getDates().size(); i++) {
                 dateChoiceBox.getItems().add(groupList.get(saveGroup).getStudentList().get(saveStudent).getDates().get(i).toString());
             }
         }
    }
    @FXML
    private void saveDateSelect(){
        for(int i = 0; i < groupList.get(saveGroup).getStudentList().get(saveStudent).getDates().size(); i++){
//            System.out.println("%%%%%%%%%%%%%%%%%%5");
//            System.out.println(groupList.get(saveGroup).getStudentList().get(saveStudent).getDates().get(i));
//            System.out.println(groupList.get(saveGroup).getStudentList().get(saveStudent).getDates().get(i).toString());
//            System.out.println(dateChoiceBox.getValue());
            if(groupList.get(saveGroup).getStudentList().get(saveStudent).getDates().get(i).toString().equals(
                    dateChoiceBox.getValue())){
                saveDate = i;
                return;
            }
        }
    }
    @FXML
    private void changeGroupName(){
        if(saveGroup != -1) {
            groupList.get(saveGroup).changeName(groupTextField.getText());
            initialize();
            Main.saveGroupList(groupList);
        }
        //Main.saveGroupList(groupList);
    }
    @FXML
    private void changeStudentName(){
        if(saveStudent != -1) {
            groupList.get(saveGroup).getStudentList().get(saveStudent).changeName(studentNameTextField.getText(), studentSurnameTextField.getText());
            Main.saveGroupList(groupList);
            loadStudents();
        }
        //Main.saveGroupList(groupList);
    }
    @FXML
    private void changeDate(){
        if(saveDate != -1) {
            groupList.get(saveGroup).getStudentList().get(saveStudent).changeDate(datePicker.getValue(), saveDate);
            Main.saveGroupList(groupList);
            loadDates();
        }
        //Main.saveGroupList(groupList);
    }
    @FXML
    private void deleteGroup(){
        if(saveGroup != -1) {
            groupList.remove(saveGroup);
            Main.saveGroupList(groupList);
            initialize();
        }
    }
    @FXML
    private void deleteStudent(){
        if(saveStudent != -1) {
            groupList.get(saveGroup).getStudentList().remove(saveStudent);
            Main.saveGroupList(groupList);
            loadStudents();
        }
    }
    @FXML
    private void deleteDate(){
        if(saveDate != -1) {
            groupList.get(saveGroup).getStudentList().get(saveStudent).getDates().remove(saveDate);
            Main.saveGroupList(groupList);
            loadDates();
        }
    }
}
