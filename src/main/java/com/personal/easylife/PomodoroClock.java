package com.personal.easylife;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PomodoroClock extends Application {

    private int minutes = 25; // Default work time in minutes
    private int seconds = 0;  // Default work time in seconds
    private boolean isBreak = false; // Flag to indicate if it's break time or work time

    private final Label timerLabel = new Label();
    private final Button startButton = new Button("Start");
    private final Button resetButton = new Button("Reset");

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(timerLabel, startButton, resetButton);

        // Set event handlers for buttons
        startButton.setOnAction(e -> startTimer());
        resetButton.setOnAction(e -> resetTimer());

        // Set initial timer display
        updateTimerDisplay();

        Scene scene = new Scene(root, 200, 150);
        primaryStage.setTitle("Pomodoro Clock");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void startTimer() {
        // Disable the start button during the timer
        startButton.setDisable(true);

        Thread timerThread = new Thread(() -> {
            try {
                while (minutes >= 0) {
                    // Update the timer display using Platform.runLater()
                    Platform.runLater(this::updateTimerDisplay);

                    // Sleep for 1 second
                    Thread.sleep(1000);

                    // Decrease the time by 1 second
                    if (seconds == 0) {
                        seconds = 59;
                        minutes--;
                    } else {
                        seconds--;
                    }
                }

                // After work time is completed, check if it's break time or work time
                if (isBreak) {
                    minutes = 25; // Set the break time to 25 minutes
                } else {
                    minutes = 5;  // Set the work time to 5 minutes
                }

                // Toggle break/work flag
                isBreak = !isBreak;

                // Restart the timer for the break/work time
                startTimer();

            } catch (InterruptedException e) {
                // Handle the interruption if needed
            }
        });

        timerThread.start();
    }

    private void resetTimer() {
        minutes = 25;
        seconds = 0;
        isBreak = false;
        startButton.setDisable(false);
        updateTimerDisplay();
    }

    private void updateTimerDisplay() {
        String time = String.format("%02d:%02d", minutes, seconds);
        timerLabel.setText(time);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
