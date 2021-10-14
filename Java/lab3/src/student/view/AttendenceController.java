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
import javafx.stage.Stage;
import javafx.util.Callback;
import student.Group;
import student.Main;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

public class AttendenceController {
    @FXML
    private ChoiceBox<String> attendenceStudentChoiceBox;

    @FXML
    private Button attendenceButton;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ChoiceBox<String> attendenceGroupChoiceBox;

    private int saveGroup, saveStudent;

    @FXML
    private void initialize(){
        ArrayList<Group> cities;

        //ObservableList<String> list = FXCollections.observableArrayList("aaaa", "bbbbb", "ccccc");
        ObservableList<Group> groupList = Main.getGroupList();
        System.out.println("ssss");

        for(int i = 0; i <groupList.size(); i++){
            System.out.println(groupList.get(i).getStudentList().size());
        }



        //studentChoiceBox.setValue("veikia");
        //studentChoiceBox.setItems(list);

        for(int i = 0; i < groupList.size(); i++) {
            attendenceGroupChoiceBox.getItems().add(groupList.get(i).getName());
        }
        if(attendenceGroupChoiceBox.getValue() != null){
            System.out.println("ifAttenendceGroup");

            String selected = attendenceGroupChoiceBox.getValue();

            int i = 0;
            while(groupList.get(i).getName().equals(selected)){
                i++;
            }
            attendenceStudentChoiceBox.getItems().clear();
            for(int j = 0; j < groupList.get(i).getStudentList().size(); j++){
                attendenceStudentChoiceBox.getItems().add(groupList.get(i).getStudentList().get(j).print());
            }
        }

    }
    @FXML
    private void dragDetected(ActionEvent event){
        System.out.println("dragDetected");

//        String selected = attendenceGroupChoiceBox.getValue();
//        ObservableList<Group> groupList = Main.getGroupList();
//
//        int i = 0;
//        while(groupList.get(i).getName() != selected){
//            i++;
//        }
//        for(int j = 0; j < groupList.get(i).getStudentList().size(); j++){
//            attendenceStudentChoiceBox.getItems().add(groupList.get(i).getStudentList().get(j).print());
//        }
    }

    @FXML
    private void selectStudent(ActionEvent event){
        ObservableList<Group> groupList = Main.getGroupList();
        if(attendenceGroupChoiceBox.getValue() != null){
            System.out.println("ifAttenendceGroup");

            String selected = attendenceGroupChoiceBox.getValue();

            int i = 0;
            while(groupList.get(i).getName() != selected){
                i++;
            }
            attendenceStudentChoiceBox.getItems().clear();
            for(int j = 0; j < groupList.get(i).getStudentList().size(); j++){
                attendenceStudentChoiceBox.getItems().add(groupList.get(i).getStudentList().get(j).print());
            }
        }
    }
    @FXML
    private void selectDate(ActionEvent event){
        System.out.println("selectDatePressed");
        ObservableList<Group> groupList = Main.getGroupList();
        String group = attendenceGroupChoiceBox.getValue();
        String student = attendenceStudentChoiceBox.getValue();
        int i = 0;
        for(; i < groupList.size(); i++){
            if(groupList.get(i).getName().equals(group)){
                groupList.get(i).addDate(datePicker.getValue());
                break;
            }
        }
        for(int j = 0; j < groupList.get(i).getStudentList().size(); j++){
            if(groupList.get(i).getStudentList().get(j).print().equals(student)){
                groupList.get(i).getStudentList().get(j).addDate(datePicker.getValue());
                break;
            }
        }
    }
}
