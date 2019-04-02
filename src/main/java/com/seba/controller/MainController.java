package com.seba.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

/**
 * Created by Sebastian on 14.04.2017.
 */
public class MainController {

    @FXML
    private StackPane mainStackPane;

    @FXML
    public void initialize(){
        loadMenuView();
    }

    public void loadMenuView() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getClassLoader().getResource("MenuView.fxml"));
        Pane pane = null;
        try {
             pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MenuController menuController = loader.getController();
        menuController.setMainController(this);
        setStackPane(pane);
    }
    public void setStackPane(Pane pane) {
        mainStackPane.getChildren().clear();
        mainStackPane.getChildren().add(pane);
    }
}
