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
import com.seba.exception.IncorrectText;
import com.seba.exception.NullStringException;
import com.seba.sample.BeufortaCipher;

/**
 * Created by Sebastian on 15.04.2017.
 */
public class BeufotraViewController {

    private MainController mainController;
    private String key;
    private String text;
    private BeufortaCipher beufortaCipher;

    @FXML
    private TextField textToEncryption;
    @FXML
    private TextField keyShift;
    @FXML
    private Button btnEncrypt;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnSend;
    @FXML
    private Label messageText;
    @FXML
    private TextField showEncryptionText;

    public void initialize(){
        EventHandler<ActionEvent> backToMenuHandler = e -> {
            mainController.loadMenuView();
        };

        EventHandler<ActionEvent> encryptTextHandler = e ->{

            try{
                key = IOTextFieldHandler.getText(keyShift);
            } catch (IncorrectText incorrectText) {
                messageText.setText(Messages.TEXT_FIELD_ERROR);
            } catch (NullStringException e1) {
                messageText.setText(Messages.TEXT_FIELD_ERROR);
            }

            try {
                text = IOTextFieldHandler.getText(textToEncryption);
            } catch (IncorrectText incorrectText) {
                messageText.setText(Messages.TEXT_FIELD_ERROR);
            } catch (NullStringException e1) {
                messageText.setText(Messages.TEXT_FIELD_ERROR);
            }

            try {
                beufortaCipher = new BeufortaCipher(key,text);
                String cipher = beufortaCipher.beufortaEncryption();
                showEncryptionText.setText(cipher);

            } catch (Exception ex){ }

        };
        EventHandler<MouseEvent> keyTextHandler = e-> { messageText.setText(""); };
        EventHandler<MouseEvent> textHandler = e-> { messageText.setText(""); };
        btnBack.getStyleClass().add("btnBack");
        btnEncrypt.getStyleClass().add("btnEncrypt");
        btnSend.getStyleClass().add("btnSend");
        btnBack.addEventHandler(ActionEvent.ACTION, backToMenuHandler);

        messageText.setText("");
        btnEncrypt.addEventHandler((ActionEvent.ACTION),encryptTextHandler);
        keyShift.addEventHandler(MouseEvent.MOUSE_CLICKED,keyTextHandler);
        textToEncryption.addEventHandler(MouseEvent.MOUSE_CLICKED,textHandler);
        textToEncryption.setPromptText("Enter text to encryption");
        keyShift.setPromptText("Enter key shift");
    }
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}

