package com.personal.easylife.controller;

import com.personal.easylife.model.PomodoroModel;
import com.personal.easylife.view.PomodoroView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class PomodoroController extends Application{
    private final PomodoroModel model = new PomodoroModel();
    private PomodoroView view;

    @Override
    public void start(Stage primaryStage) {
        view = new PomodoroView(primaryStage, model);

        // Start the timer
        startTimer();
    }

    private void startTimer() {
        Thread timerThread = new Thread(() -> {
            try {
                while (model.getMinutes() >= 0) {
                    // Update the view using Platform.runLater() to safely interact with the GUI
                    Platform.runLater(() -> {
                        view.updateView();
                        if (!model.isPaused()) {
                            updateTimer();
                        }
                    });

                    // Sleep for 1 second
                    Thread.sleep(1000);
                }

                // If it was a work session, increase the cycles completed by the user
                if (!model.isBreak()) {
                    model.setCycles(model.getCycles() + 1);
                }

                // After work time is completed, check if it's break time or work time
                if (model.isBreak()) {
                    model.setMinutes(25); // Set the break time to 25 minutes
                } else {
                    model.setMinutes(5);  // Set the work time to 5 minutes
                }

                // Toggle break/work flag
                model.setBreak(!model.isBreak());

                // Restart the timer for the break/work time
                startTimer();

            } catch (InterruptedException e) {
                // Handle the interruption if needed
            }
        });

        timerThread.start();
    }

    private void updateTimer() {
        if (model.getSeconds() == 0) {
            model.setSeconds(59);
            model.setMinutes(model.getMinutes() - 1);
        } else {
            model.setSeconds(model.getSeconds() - 1);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}