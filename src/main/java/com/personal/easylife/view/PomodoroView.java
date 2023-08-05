package com.personal.easylife.view;

import com.personal.easylife.model.PomodoroModel;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class PomodoroView {
    private final PomodoroModel model;
    private final Stage primaryStage;

    private final Label cycleLabel = new Label("Cycles: 0"); // Initialize with 0 cycles
    private final Label timerLabel = new Label();
    private final Button startButton = new Button("Start");
    private final Button resetButton = new Button("Reset");
    private final Button pauseButton = new Button("Pause");

    public PomodoroView(Stage primaryStage, PomodoroModel model) {
        this.primaryStage = primaryStage;
        this.model = model;
        initView();
        initEventHandlers();
    }

    private void initView() {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(timerLabel, cycleLabel, startButton, resetButton, pauseButton);

        Scene scene = new Scene(root, 200, 150);
        primaryStage.setTitle("Pomodoro Clock");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initEventHandlers() {
        startButton.setOnAction(e -> model.setPaused(false));
        resetButton.setOnAction(e -> model.setPaused(false));
        pauseButton.setOnAction(e -> model.setPaused(!model.isPaused()));
    }

    public void updateView() {
        String time = String.format("%02d:%02d", model.getMinutes(), model.getSeconds());
        timerLabel.setText(time);
        cycleLabel.setText("Cycles: " + model.getCycles());
        if (model.isPaused()) {
            pauseButton.setText("Play");
        } else {
            pauseButton.setText("Pause");
        }
    }
}
