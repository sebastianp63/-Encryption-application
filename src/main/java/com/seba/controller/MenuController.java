package com.seba.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * Created by Sebastian on 14.04.2017.
 */
public class MenuController {

    private MainController mainController;
    @FXML
    private Button goToCesar;
    @FXML
    private Button goToVinegere;
    @FXML
    private Button goToBeuforta;
    @FXML
    private Button goToDeviceConnect;

    @FXML
    public void initialize(){
            goToCesar.getStyleClass().add("btnCesar");
            goToVinegere.getStyleClass().add("btnVinegere");
            goToBeuforta.getStyleClass().add("btnBeuforta");
            goToDeviceConnect.getStyleClass().add("btnDevice");

        EventHandler<ActionEvent> cesarHandler = e-> {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("CesarView.fxml"));
            Pane pane = null;
            try {
                 pane = loader.load();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            CesarViewController cesarViewController = loader.getController();
            cesarViewController.setMainController(mainController);
            mainController.setStackPane(pane);
        };

        EventHandler<ActionEvent> vinegereHandler = e-> {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("VinegereView.fxml"));
            Pane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            VinegereViewController vinegereViewController = loader.getController();
            vinegereViewController.setMainController(mainController);
            mainController.setStackPane(pane);
        };

        EventHandler<ActionEvent> beufortaHandler = e-> {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("BeufortaView.fxml"));
            Pane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            BeufotraViewController beufortaViewController = loader.getController();
            beufortaViewController.setMainController(mainController);
            mainController.setStackPane(pane);
        };

        EventHandler<ActionEvent> bluetoothHandler = e-> {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("BluetoothView.fxml"));
            Pane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            BluetoothViewController bluetoothViewController = loader.getController();
            bluetoothViewController.setMainController(mainController);
            mainController.setStackPane(pane);
        };

        goToCesar.addEventHandler(ActionEvent.ACTION,cesarHandler);
        goToVinegere.addEventHandler(ActionEvent.ACTION, vinegereHandler);
        goToBeuforta.addEventHandler(ActionEvent.ACTION, beufortaHandler);
        goToDeviceConnect.addEventHandler(ActionEvent.ACTION, bluetoothHandler);

    }
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
