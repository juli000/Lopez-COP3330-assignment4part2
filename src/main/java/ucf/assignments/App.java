/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Julio Lopez
 */

package ucf.assignments;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class App extends Application {

    public static void main(String[] args) { launch(args);}

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = null;
        try{
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        }catch (IOException e){
            throw new RuntimeException();
        }
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
