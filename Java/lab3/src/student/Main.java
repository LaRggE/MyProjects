package student;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;

public class Main extends Application {


    private static  Stage primaryStage;
    private GridPane mainLayout;
    private static ObservableList<Group> groupList = FXCollections.observableArrayList();


    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("name");

        readTxtFile();
        showMainView();
        //writeTxtFile();

    }
    private void showMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/MainView.fxml"));
        mainLayout = loader.load();
        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void readTxtFile() throws IOException {
        String fileName = "C:\\Users\\Ignas\\Documents\\Java\\uzd3v3\\src\\student\\groups.txt";
        String line = null;

        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int i = -1;
        int k = -1;
        line = bufferedReader.readLine();
        while(line != null){
            if(line.equals("@")){
                //System.out.println("works");
                line = bufferedReader.readLine();
                groupList.add(new Group(line));
                k = -1;
                i++;
                line = bufferedReader.readLine();
            }
            if(line == null){
                break;
            }
            if(line.equals("#")){
                line = bufferedReader.readLine();
                String temp = bufferedReader.readLine();
                System.out.println(line + " " + temp);
                groupList.get(i).addStudent(line, temp);
                k++;
                line = bufferedReader.readLine();
            }
            if(line == null){
                break;
            }
            if(line.equals("%")){
                line = bufferedReader.readLine();
                LocalDate localDate = LocalDate.parse(line);
                groupList.get(i).getStudentList().get(k).addDate(localDate);
                line = bufferedReader.readLine();
            }
            System.out.println(line);
        }
        bufferedReader.close();
        //writeTxtFile();
    }
    public static void writeTxtFile() throws IOException {
        String fileName = "C:\\Users\\Ignas\\Documents\\Java\\uzd3v3\\src\\student\\groups.txt";
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for(int i = 0; i < groupList.size();i++){
            bufferedWriter.write("@");
            bufferedWriter.newLine();
            bufferedWriter.write(groupList.get(i).getName());
            for(int j = 0; j < groupList.get(i).getStudentList().size();j++){
                bufferedWriter.newLine();
                bufferedWriter.write("#");
                bufferedWriter.newLine();
                bufferedWriter.write(groupList.get(i).getStudentList().get(j).getName());
                bufferedWriter.newLine();
                bufferedWriter.write(groupList.get(i).getStudentList().get(j).getSurname());
                for (int k = 0; k < groupList.get(i).getStudentList().get(j).getDates().size(); k++){
                    bufferedWriter.newLine();
                    bufferedWriter.write("%");
                    bufferedWriter.newLine();
                    bufferedWriter.write(groupList.get(i).getStudentList().get(j).getDates().get(k).toString());
                }
            }
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
    public static void showAddGroup() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/AddGroup.fxml"));
        GridPane addGroup = loader.load();

        Stage addGroupStage = new Stage();
        addGroupStage.setTitle("Group");
        addGroupStage.setScene(new Scene(addGroup, 220,120));
        addGroupStage.show();
    }
    public static void showAddStudent() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/AddStudents.fxml"));
        AnchorPane addGroup = loader.load();

        Stage addGroupStage = new Stage();
        addGroupStage.setTitle("Student");
        addGroupStage.setScene(new Scene(addGroup, 380,200));
        addGroupStage.show();
    }
    public static ObservableList<Group> getGroupList(){
        return groupList;
    }
    public static void saveGroupList(ObservableList<Group> saveGroupList){
        groupList = saveGroupList;
    }

    public static void main(String[] args) {
        launch(args);

    }
}
