/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Julio Lopez
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.*;
import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ListView<String> listTitles;

    @FXML
    private Button clearListButton;

    @FXML
    private ToggleButton completeButton;

    @FXML
    private Button createListButton;

    @FXML
    private TextField dateInput;

    @FXML
    private TableView<todoItem> dataTable;

    @FXML TableColumn<todoItem, String> dateCol;
    @FXML TableColumn<todoItem, String> compCol;
    @FXML TableColumn<todoItem, String> descCol;


    @FXML
    private ToggleButton incompleteButton;

    @FXML
    private TextField nameInput;

    @FXML
    private Button saveListButton;

    @FXML
    private Button uploadListButton;

    @FXML
    private Button addItemButton;

    @FXML
    private void uploadList(ActionEvent event){
        FileChooser f = new FileChooser();
        f.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File i = f.showOpenDialog(new Stage());
        if(i != null){
            listTitles.getItems().add(i.getName().substring(0,i.getName().lastIndexOf(".")));
        }
    }

    public ObservableList<todoItem> getItems(){
        dateCol.setCellValueFactory(new PropertyValueFactory<todoItem, String>("date"));
        compCol.setCellValueFactory(new PropertyValueFactory<todoItem, String>("comp"));
        descCol.setCellValueFactory(new PropertyValueFactory<todoItem, String>("desc"));
        ObservableList<todoItem> items = FXCollections.observableArrayList();
        String path = "/Users/juliolopez/IdeaProjects/Lopez-COP3330-assignment4/src/main/java/ucf/assignments/Example.csv";
        String line  = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line = br.readLine()) != null){
                String[] spot = line.split(",", -1);
                todoItem n = new todoItem(spot[0],spot[1],spot[2]);
                items.add(n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(items);
        return items;
    }

    public void addList() {
        /*
            creates new list within main file
            use input fields
         */
    }

    public void removeList() {
        /*
           If a list is selected
           And user is not within the table view
           And user presses delete it will remove the list
         */
    }

    public void editTitle() {
        /*
            If user double-clicks on the name of a list item
            Then they will be prompted to enter a new title
            Reload all lists
         */
    }
    @FXML
    public void promptTableUpdate(javafx.event.ActionEvent actionEvent) {
        dataTable.setItems(getItems());
    }

    public void editItem() {
        /*
            If user double-clicks on the row within tableview
            Then they will be prompted to enter all fields again
            Reload all items
         */
    }

    public void completeItem() {
        /*
            If button Complete Item is pressed then the rows under the cursor
            will be highlighted and user will click to complete
         */
    }

    public void showCompleted() {
        /*
            While toggle button is pressed it will show only completed items
            Go through the column completed and determine whether it should be shown
         */
    }

    public void showNotCompleted() {
        /*
            While toggle button is pressed it will show only completed items
            Go through the column completed and determine whether it should be shown
         */
    }

    public void saveIndividualList(javafx.event.ActionEvent actionEvent) {
        FileChooser f = new FileChooser();
        File i = f.showSaveDialog(new Stage());
        if(i != null){
            save(i);
        }
    }

    public void save(File f){

    }

    public void saveAllList() {
        /*
            If the save all button is pressed then all lists will be saved within one file
            will be saved to external storage
         */
    }


    public void updateView(){
        /*
            Will reload all lists as well as the table view
         */
    }

    public void createList(javafx.event.ActionEvent actionEvent) {
        listTitles.getItems().add(nameInput.getText());
    }


    public void clearList(javafx.event.ActionEvent actionEvent) {
    }

    public void addItemList(javafx.event.ActionEvent actionEvent) {
        Parent root = null;
        try{
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("createWindow.fxml")));
        }catch (IOException e){
            throw new RuntimeException();
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Create New Item in List");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
