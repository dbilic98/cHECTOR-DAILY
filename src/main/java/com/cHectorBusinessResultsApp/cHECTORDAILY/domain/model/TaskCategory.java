package com.cHectorBusinessResultsApp.cHECTORDAILY.domain.model;

import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.enumeration.TaskType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(schema = "erp_administration", name = "erp_kategorije_taska")
public class TaskCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private TaskType name;

    @JsonIgnore
    @OneToMany(mappedBy = "taskCategory")
    private List<Task> tasks;

    public TaskCategory() {
    }

    public TaskCategory(TaskType name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TaskType getName() {
        return name;
    }

    public void setName(TaskType name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}

