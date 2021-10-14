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


public class AddGroupController {

    @FXML
    private TextField groupTextField;

    @FXML
    private Button submitGroup;


    @FXML
    void pressSubmitGroupButton(ActionEvent event) throws IOException {
        ObservableList<Group> groupList = Main.getGroupList();
        try {
            String name = groupTextField.getText();
            System.out.println(name);
            if(name == ""){
                return;
            }
            groupList.add(new Group(name));
            System.out.println(groupList.size());
        }
        catch (Exception  e){
            System.out.println("AddGroupController Error");
        }

    }


}
