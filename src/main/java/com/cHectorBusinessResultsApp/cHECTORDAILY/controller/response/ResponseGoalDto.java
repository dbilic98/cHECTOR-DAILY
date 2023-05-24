package com.cHectorBusinessResultsApp.cHECTORDAILY.controller.response;

import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.enumeration.GoalType;

import java.time.LocalDate;

public class ResponseGoalDto {

    private String title;
    private GoalType goalType;
    private LocalDate date;
    private String notes;
    private boolean isCompleted;

    public ResponseGoalDto(String title, GoalType goalType, LocalDate date, String notes, boolean isCompleted) {
        this.title = title;
        this.goalType = goalType;
        this.date = date;
        this.notes = notes;
        this.isCompleted = isCompleted;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GoalType getGoalType() {
        return goalType;
    }

    public void setGoalType(GoalType goalType) {
        this.goalType = goalType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isCompleted() { return isCompleted; }

    public void setCompleted(boolean completed) { isCompleted = completed; }
}


