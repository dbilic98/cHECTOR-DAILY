package com.cHectorBusinessResultsApp.cHECTORDAILY.controller.request;

import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.enumeration.TaskType;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class RequestTaskDto {
    @NotBlank(message = "Title is mandatory")
    @Size(min = 4, max = 12, message = "Name should be at least 4 characters, and should not exceed 12 characters.")
    private String title;

    private TaskType taskType;

    @FutureOrPresent(message = "The date must be today or in the future")
    private LocalDate date;

    @NotBlank(message = "Notes is mandatory")
    @Size(min = 4, max = 200, message = "Name should be at least 4 characters, and should not exceed 200 characters.")
    private String notes;

    private boolean isCompleted;

    public RequestTaskDto(String title, TaskType taskType, LocalDate date, String notes, boolean isCompleted) {
        this.title = title;
        this.taskType = taskType;
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

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
