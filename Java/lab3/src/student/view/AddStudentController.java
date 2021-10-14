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

import java.io.IOException;
import java.util.ArrayList;

public class AddStudentController {
    @FXML
    private Button studentSubmitButton;

    @FXML
    private ChoiceBox<String> studentChoiceBox = new ChoiceBox<>();

    @FXML
    private TextField studentNameTextField;

    @FXML
    private TextField studentSurnameTextField;


    @FXML
    private void initialize(){
        ArrayList<Group> cities;
        //ObservableList<String> list = FXCollections.observableArrayList("aaaa", "bbbbb", "ccccc");
        ObservableList<Group> groupList = Main.getGroupList();
        System.out.println("ssss");
        //studentChoiceBox.setValue("veikia");
        //studentChoiceBox.setItems(list);
        for(int i = 0; i < groupList.size(); i++) {
            studentChoiceBox.getItems().add(groupList.get(i).getName());
        }
    }

    @FXML
    private void pressSubmitStudentButton(ActionEvent event) throws IOException {
        ObservableList<Group> groupList = Main.getGroupList();
        int i = 0;
        while(studentChoiceBox.getValue() != null
        && groupList.get(i).getName() != studentChoiceBox.getValue()) {
            i++;
        }
        String name = studentNameTextField.getText();
        String surmame = studentSurnameTextField.getText();
        if(name != null && surmame != null) {
            groupList.get(i).addStudent(name, surmame);
        }
        Main.saveGroupList(groupList);

    }

}
