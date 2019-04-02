package com.seba.controller;

import com.fazecast.jSerialComm.SerialPort;
import com.seba.handler.BluetoothHandler;
import com.seba.handler.IOTextFieldHandler;
import com.seba.meesage.Messages;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



/**
 * Created by Sebastian on 15.04.2017.
 */
public class BluetoothViewController {



    private MainController mainController;
    private BluetoothHandler bluetoothHandler  = new BluetoothHandler();;
    private boolean connectStatus = false;

    private int baudRate=9600;
    private  int dataBits=8;
    private int stopBits=1;


    @FXML
    private Button btnBack;
    @FXML
    private Button btnScan;
    @FXML
    private Button btnConnect;
    @FXML
    private ListView list;
    @FXML
    private Rectangle showConnection ;
    @FXML
    private ChoiceBox<String> baudRateBox;
    @FXML
    private Label messageConnection;
    @FXML
    private TextField dataBitsField;
    @FXML
    private TextField stopBitsField;

    public void initialize(){
        EventHandler<ActionEvent> backToMenuHandler = e -> {
            mainController.loadMenuView();

        };

        baudRateBox.getItems().addAll("2400","4800","9600","14400","19200");
        baudRateBox.setValue("9600");
        dataBitsField.setText("8");
        stopBitsField.setText("1");

        EventHandler<ActionEvent> scanningForDevice = e -> {
            list.getItems().clear();
          SerialPort[] ports =  bluetoothHandler.getPort();
          for(SerialPort p: ports){
              list.getItems().add(p.getSystemPortName());
          }
        };

        EventHandler<ActionEvent> connectHandler = e -> {

            try {
                 baudRate =Integer.parseInt(baudRateBox.getValue());
                 dataBits = Integer.parseInt(dataBitsField.getText());
                 stopBits = Integer.parseInt(stopBitsField.getText());

            } catch (Exception e1) {}

            try {

                if (!connectStatus) {
                    bluetoothHandler.setSerialPort(list.getSelectionModel().getSelectedItem().toString());
                    bluetoothHandler.Connect(baudRate, dataBits, stopBits);

                    if (bluetoothHandler.isOpen()) {
                        btnConnect.setText("Disconnect");
                        messageConnection.setText(Messages.CONNECTED);
                        showConnection.setFill(Color.GREEN);
                        connectStatus = true;
                        list.setDisable(true);
                        btnScan.setDisable(true);
                    }
                } else if (connectStatus) {

                    bluetoothHandler.getChosenPort().closePort();
                    showConnection.setFill(Color.RED);
                    btnConnect.setText("Connect");
                    messageConnection.setText(Messages.DISCONNECTED);
                    connectStatus = false;
                    list.setDisable(false);
                    btnScan.setDisable(false);
                }
            } catch (NullPointerException e2 ) {}
        };

        btnBack.getStyleClass().add("btnBack");
        messageConnection.setText(Messages.DISCONNECTED);
        btnBack.addEventHandler(ActionEvent.ACTION, backToMenuHandler);
        btnScan.addEventHandler(ActionEvent.ACTION, scanningForDevice );
        btnConnect.addEventHandler(ActionEvent.ACTION, connectHandler);
    }
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
