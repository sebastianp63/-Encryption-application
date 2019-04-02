package com.seba.sample;

/**
 * Created by Sebastian on 21.04.2017.
 */
public class BeufortaCipher {
    private String text;
    private String key;

    public BeufortaCipher(String key, String text){
        this.key = key;
        this.text = text;
    }

    private static char[] getChars(String textToEncryption) {
        char[] charTab = textToEncryption.toCharArray();
        return charTab;
    }

    public String beufortaEncryption(){
        text = text.toUpperCase();
        key = key.toUpperCase();
        char[] charText = getChars(text);
        char[] keyShift =  getChars(key);

        if(checkText(charText) && checkText(keyShift)){
            for (int i = 0, j = 0; i < charText.length; i++) {
                int ascii = (int)charText[i];
                ascii =(Math.abs((keyShift[i]-65) - (ascii-65)))%26 +65;
                // ascii = ((26 - 1) - (ascii-65) + ((keyShift[i]-65) +1))%26+65;
                charText[i]= (char)ascii;
                j = ++j % key.length();
            }
        }
        return new String(charText);
    }

    private boolean checkText(char[] text) {
        boolean value = false;
        for (char e : text) {
            if (e < 'A' || e > 'Z' ) {
                value=false;
            } else value = true;
        }
        return value;
    }
}
