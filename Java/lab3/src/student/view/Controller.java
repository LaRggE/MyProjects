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


public class Controller {
    @FXML
    private TextField groupTextField;
    @FXML
    private ChoiceBox<String> studentChoiceBox = new ChoiceBox<>();
    @FXML
    private TextField studentNameTextField;
    @FXML
    private TextField studentSurnameTextField;

    private ObservableList<Group> groupList = FXCollections.observableArrayList();
   // private ObservableList<String> testList = FXCollections.observableArrayList("single", "aaaa", "asdasd");



//    private void initialize(){
//        ArrayList<Group> cities;
//        ObservableList<String> list = FXCollections.observableArrayList("aaaa", "bbbbb", "ccccc");
//        groupList.add(new Group("aa"));
//        groupList.add(new Group("bb"));
//        System.out.println("ssss");
//        //studentChoiceBox.setValue("veikia");
//        //studentChoiceBox.setItems(list);
//        for(int i = 0; i < groupList.size(); i++) {
//            studentChoiceBox.getItems().add(groupList.get(i).getName());
//        }
//        //studentChoiceBox.getSelectionModel().getSelectedIndex("name");
//        //studentChoiceBox.selectionModelProperty()
//
//    }
    public void pressAddGroupButton(ActionEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//        Stage secondaryStage = new Stage();
//
//        Parent root = loader.load(getClass().getResource("AddGroup.fxml"));
//
//        secondaryStage.setTitle("Group");
//        secondaryStage.setScene(new Scene(root, 200,110));
//        secondaryStage.show();
        Main.showAddGroup();

    }
    public void pressAddStudentButton(ActionEvent event) throws IOException {
        Main.showAddStudent();;
    }
    public void pressAttendenceButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Stage secondaryStage = new Stage();


        Parent root = loader.load(getClass().getResource("Attendence.fxml"));


        secondaryStage.setTitle("Student");
        secondaryStage.setScene(new Scene(root, 250,250));
        secondaryStage.show();

    }
    public void pressSubmitGroupButton(ActionEvent event){
        String name = groupTextField.getText();
        groupList.add(new Group("aaaa"));
        System.out.println(groupList.size());
//        for(int i = 0; i < groupList.size(); i++){
//            System.out.println(groupList.get(i).print());
//        }
    }
    public void pressSubmitStudentButton(ActionEvent event){
        System.out.println("pressSubmitStudentButton");
        int i = 0;
        while(groupList.get(i).getName() != studentChoiceBox.getValue()) {
            i++;
        }
        String name = studentNameTextField.getText();
        String surmame = studentSurnameTextField.getText();

        groupList.get(i).addStudent(name, surmame);

        //System.out.println(studentChoiceBox.getValue());
    }
    public void pressListButton() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Stage secondaryStage = new Stage();


        Parent root = loader.load(getClass().getResource("ShowList.fxml"));


        secondaryStage.setTitle("Student");
        secondaryStage.setScene(new Scene(root, 600,400));
        secondaryStage.show();
    }
    public void pressModifyButton() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Stage secondaryStage = new Stage();


        Parent root = loader.load(getClass().getResource("Modify.fxml"));

        secondaryStage.setTitle("Modify");
        secondaryStage.setScene(new Scene(root, 600,250));
        secondaryStage.show();
    }
    @FXML
    private void pressSaveToTxt(ActionEvent event) throws IOException {
        Main.writeTxtFile();
    }

}
