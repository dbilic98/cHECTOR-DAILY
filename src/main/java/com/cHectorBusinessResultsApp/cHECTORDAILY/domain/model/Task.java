package com.cHectorBusinessResultsApp.cHECTORDAILY.domain.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(schema = "erp_administration", name = "erp_taskovi")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "notes")
    private String notes;

    @Column(name = "is_completed", columnDefinition = "boolean default false")
    private boolean isCompleted;

    @ManyToOne
    @JoinColumn(name = "task_category_id", nullable = false)
    private TaskCategory taskCategory;

    public Task() {
    }

    public Task(String title, LocalDate date, String notes, TaskCategory taskCategory) {
        this.title = title;
        this.date = date;
        this.notes = notes;
        this.isCompleted = false;
        this.taskCategory = taskCategory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public TaskCategory getTaskCategory() {
        return taskCategory;
    }

    public void setTaskCategory(TaskCategory taskCategory) {
        this.taskCategory = taskCategory;
    }
}
