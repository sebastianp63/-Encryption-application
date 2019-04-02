package com.seba.sample;

/**
 * Created by Sebastian on 20.04.2017.
 */
public class CesarCipher {

    private int keyShift;
    private String textToEncryption;

    public CesarCipher(int keyShift, String textToEncryption){
        this.keyShift = keyShift;
        this.textToEncryption = textToEncryption;
    }

    private static char[] getChars(String textToEncryption) {
        char[] charTab = textToEncryption.toCharArray();
        return charTab;
    }

    public String cesarEncryption() {
        char charTab[] = getChars(textToEncryption);

        for (int i = 0; i <charTab.length ; i++) {
            if( charTab[i]>='A' && charTab[i]<='Z' ){
                int ascii = (int)charTab[i];
                ascii = (ascii -65 + keyShift)%26 +65;
                charTab[i]=(char)ascii;
            } else if( charTab[i]>='a' && charTab[i]<='z'){
                int ascii = (int)charTab[i];
                ascii = (ascii -97 + keyShift)%26 +97;
                charTab[i]=(char)ascii;
            } else if(charTab[i] == 20) { charTab[i] = charTab[i]; }
        }
        return new String(charTab);
    }

}

