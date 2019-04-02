package com.seba.handler;

import javafx.scene.control.TextField;

/**
 * Created by Sebastian on 21.04.2017.
 */
public class IOTextFieldHandler {

    public static int getKey(TextField textField ) throws com.seba.exception.InvalidValue, NullPointerException{
        int keyValue = Integer.parseInt(textField.getText());
        if(keyValue<1 || keyValue >26) {
            throw new com.seba.exception.InvalidValue("Invalid value");

        } else return keyValue;
    }

    public static String getText(TextField textField) throws com.seba.exception.IncorrectText, com.seba.exception.NullStringException {
        String text = textField.getText();
        char[] charsText = text.toCharArray();
        if(text.isEmpty()) {throw new com.seba.exception.NullStringException("Empty string");}
        for(char e: charsText){
            if( ( e < 'A' || e > 'Z' && e < 'a' || e > 'z') && e !=' '  ){throw new com.seba.exception.IncorrectText("Incorrect text ");
            }
        } return text;
    }
}
