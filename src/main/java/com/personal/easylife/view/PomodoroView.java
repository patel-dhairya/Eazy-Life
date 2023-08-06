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
    public final Button startButton = new Button("Start");
    public final Button resetButton = new Button("Reset");
    public final Button pauseButton = new Button("Pause");

    public PomodoroView(Stage primaryStage, PomodoroModel model) {
        this.primaryStage = primaryStage;
        this.model = model;
        initView();
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

    public void updateView() {
        String time = String.format("%02d:%02d", model.getMinutes(), model.getSeconds());
        timerLabel.setText(time);
        cycleLabel.setText("Cycles: " + model.getCycles());

    }
}
