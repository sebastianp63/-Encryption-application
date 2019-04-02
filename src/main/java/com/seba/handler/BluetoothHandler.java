package com.seba.handler;

import com.fazecast.jSerialComm.SerialPort;

/**
 * Created by Sebastian on 01.05.2017.
 */
public class BluetoothHandler {

    private SerialPort chosenPort;


    public static SerialPort[] getPort() {
        SerialPort[] portNames = SerialPort.getCommPorts();
        return portNames;
    }

    public void Connect( int baudRate, int dataBits, int stopBits){

        this.chosenPort.setComPortParameters(baudRate, dataBits, stopBits, SerialPort.NO_PARITY);
        this.chosenPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
    }

    public boolean isOpen(){
        if(this.chosenPort.openPort()) return true;
        else return false;
    }

    public void setSerialPort(String port){
        chosenPort = SerialPort.getCommPort(port);
    }

    public SerialPort getChosenPort(){
        return this.chosenPort;
    }
}
