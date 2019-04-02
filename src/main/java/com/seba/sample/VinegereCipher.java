package com.seba.sample;

/**
 * Created by Sebastian on 20.04.2017.
 */
public class VinegereCipher {

    private String text;
    private String key;

    public VinegereCipher(String key, String text){
        this.key = key;
        this.text = text;
    }

    private static char[] getChars(String textToEncryption) {
        char[] charTab = textToEncryption.toCharArray();
        return charTab;
    }

    public String vinegereEncryption(){
        text = text.toUpperCase();
        key = key.toUpperCase();
        char[] charText = getChars(text);
        char[] keyShift =  getChars(key);

        if(checkText(charText) && checkText(keyShift)){
            for (int i = 0, j = 0; i < charText.length; i++) {
                int ascii = (int)charText[i];

               ascii =( (Math.abs((ascii-65) + (keyShift[j]-65)))%26+65) ;
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
