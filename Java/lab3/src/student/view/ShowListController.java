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

public class ShowListController {

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private TableView<Student> tableView;

    @FXML
    private TableColumn<LocalDate, String> tableDate;

    @FXML
    private TableColumn<Student, String> tableName;

    @FXML
    private TableColumn<Student, String> tableSurname;


    ObservableList<Group> groupList = Main.getGroupList();

    @FXML
    private void initialize() throws IOException {
        for(int i = 0; i < groupList.size(); i++) {
            choiceBox.getItems().add(groupList.get(i).getName());
        }

    }
    @FXML
    private void loadInformation(){
        System.out.println("showList || loadInformation");
        tableDate.setCellValueFactory(
                new PropertyValueFactory<>("localDate"));

        tableName.setCellValueFactory(
                new PropertyValueFactory<>("name"));

        tableSurname.setCellValueFactory(
                new PropertyValueFactory<>("surname"));

        int i = 0;
        for(; i < groupList.size();i++){
            if(choiceBox.getValue().equals(groupList.get(i).getName())){
                break;
            }
        }
        tableView.getItems().clear();
        ArrayList<Student> studentList = groupList.get(i).getStudentList();
        for(int j = 0; j < studentList.size(); j++){
            for(int k = 0; k < studentList.get(j).getDates().size(); k++){
                tableView.getItems().add(
                        new Student(
                                    studentList.get(j).getLocalDates().get(k),
                                    studentList.get(j).getName(),
                                    studentList.get(j).getSurname()));
            }
        }
    }
}
