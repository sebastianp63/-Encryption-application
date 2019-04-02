package com.seba.sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
    StackPane stackPane = FXMLLoader.load(getClass().getClassLoader().getResource("MainView.fxml"));
    Scene scene1 = new Scene(stackPane,400,400);
        scene1.getStylesheets().add("Style.css");
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene1);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
public static void main(String[] args) { launch(args);}
}
