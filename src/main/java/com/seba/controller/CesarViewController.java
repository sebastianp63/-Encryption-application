package com.seba.controller;

import com.seba.handler.IOTextFieldHandler;
import com.seba.meesage.Messages;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import com.seba.sample.CesarCipher;

/**
 * Created by Sebastian on 15.04.2017.
 */
public class CesarViewController {

    private  MainController mainController;
    private CesarCipher cesarCipher;

    private int key;
    private String text;

    @FXML
    private Button btnBack;
    @FXML
    private Button btnEncrypt;
    @FXML
    private  Button btnSend;
    @FXML
    private TextField textToEncryption;
    @FXML
    private TextField keyText;
    @FXML
    private TextField showEncrytptionText;
    @FXML
    private Label messageKey;
    @FXML
    private Label messageText;

    public void initialize(){

        EventHandler<ActionEvent> backToMenuHandler = e -> { mainController.loadMenuView();
        };

        EventHandler<ActionEvent> encryptTextHandler = e -> {
            try {
                key = IOTextFieldHandler.getKey(keyText);

            } catch (com.seba.exception.InvalidValue ex) {
                messageKey.setText(Messages.INCORRECT_VALUE);
            } catch (NumberFormatException ex){
                messageKey.setText(Messages.ANOTHER_TYPE);
            } catch (NullPointerException ex){
                messageKey.setText(Messages.EMPTY_VALUE);
            }

            try{
                text = IOTextFieldHandler.getText(textToEncryption);
            } catch (com.seba.exception.IncorrectText ex) {
                messageText.setText(Messages.TEXT_FIELD_ERROR);
            } catch (com.seba.exception.NullStringException ex) {
                messageText.setText(Messages.TEXT_FIELD_ERROR);
            }
            try {
                if(key!=0){
                cesarCipher = new CesarCipher(key, text);
                String cipherText = cesarCipher.cesarEncryption();
                showEncrytptionText.setText(cipherText);
                }
            } catch (NullPointerException ex){

            }
        };
        EventHandler<MouseEvent> keyTextHandler = e-> { messageKey.setText(""); };
        EventHandler<MouseEvent> textHandler = e-> { messageText.setText(""); };

        btnBack.getStyleClass().add("btnBack");
        btnEncrypt.getStyleClass().add("btnEncrypt");
        btnSend.getStyleClass().add("btnSend");
        btnBack.addEventHandler(ActionEvent.ACTION, backToMenuHandler);
        btnEncrypt.addEventHandler((ActionEvent.ACTION),encryptTextHandler);
        messageKey.setText("");
        messageText.setText("");
        keyText.addEventHandler(MouseEvent.MOUSE_CLICKED,keyTextHandler);
        keyText.setPromptText("Key value [0-26]");
        textToEncryption.addEventHandler(MouseEvent.MOUSE_CLICKED,textHandler);
        textToEncryption.setPromptText("Enter text to encryption");


    }
    public void setMainController(MainController mainController)  { this.mainController = mainController;}

}