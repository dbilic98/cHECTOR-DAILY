package com.cHectorBusinessResultsApp.cHECTORDAILY.controller.response;

import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.enumeration.TaskType;

import java.time.LocalDate;
import java.util.UUID;

public class ResponseTaskDto {
    private UUID id;
    private String title;
    private TaskType taskType;
    private LocalDate date;
    private String notes;
    private boolean isCompleted;

    public ResponseTaskDto(UUID id,String title, TaskType taskType, LocalDate date, String notes, boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.taskType = taskType;
        this.date = date;
        this.notes = notes;
        this.isCompleted = isCompleted;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
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


