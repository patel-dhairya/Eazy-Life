package com.jdojo.intro;
import javafx.application.Application;
import javafx.stage.Stage;
public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage) {
        // Set a title for the stage
        stage.setTitle("Hello World!");
        // Show the stage
        stage.show();
    }
}


