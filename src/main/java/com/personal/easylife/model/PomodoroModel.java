package com.personal.easylife.model;

public class PomodoroModel {
    private int minutes = 25; // Default work time in minutes
    private int seconds = 0;  // Default work time in seconds
    private boolean isBreak = false; // Flag to indicate if it's break time or work time
    private int cycles = 0; // Number of pomodoro cycles user finished in single session
    private boolean isPaused = true; // Flag to keep track of whether the timer is paused or not

    // Getters and setters for the model properties

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public boolean isBreak() {
        return isBreak;
    }

    public void setBreak(boolean isBreak) {
        this.isBreak = isBreak;
    }

    public int getCycles() {
        return cycles;
    }

    public void setCycles(int cycles) {
        this.cycles = cycles;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }
}
