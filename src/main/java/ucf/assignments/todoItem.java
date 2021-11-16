/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Julio Lopez
 */

package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Objects;


public class todoItem {

    private String date;
    private String comp;
    private String desc;

    public todoItem(String d, String c, String f){
        this.date = d;
        this.comp = c;
        this.desc = f;
    }

    public String getDate() {return date;}
    public void setDate(String date) {this.date = date;}
    public String getComp() {return comp;}
    public void setComp(String comp) {this.comp = comp;}
    public String getDesc() {return desc;}
    public void setDesc(String desc) {this.desc = desc;}
}
