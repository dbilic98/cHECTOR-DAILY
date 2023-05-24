package com.cHectorBusinessResultsApp.cHECTORDAILY.domain.service;

import com.cHectorBusinessResultsApp.cHECTORDAILY.controller.request.RequestTaskDto;
import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.model.Task;
import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.model.TaskCategory;
import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.repository.TaskRepository;
import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.repository.TaskCategoryRepository;
import com.cHectorBusinessResultsApp.cHECTORDAILY.exception.TaskCategoryNotFoundException;
import com.cHectorBusinessResultsApp.cHECTORDAILY.exception.TaskNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    public final TaskRepository taskRepository;
    public final TaskCategoryRepository taskCategoryRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, TaskCategoryRepository taskCategoryRepository) {
        this.taskRepository = taskRepository;
        this.taskCategoryRepository = taskCategoryRepository;
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public Task findTaskById(Integer id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (!optionalTask.isPresent()) {
            throw new TaskNotFoundException("Task ID is not found");
        }
        return optionalTask.get();
    }

    public Task createTask(RequestTaskDto requestTaskDto) {
        Optional<TaskCategory> optionalTaskCategory = taskCategoryRepository.findByName(requestTaskDto.getTaskType());
        if (!optionalTaskCategory.isPresent()) {
            throw new TaskCategoryNotFoundException("Category name not found!");
        }
        Task task = new Task(
                requestTaskDto.getTitle(),
                requestTaskDto.getDate(),
                requestTaskDto.getNotes(),
                optionalTaskCategory.get());
        return taskRepository.save(task);
    }

    public Task updateTask(Integer id, RequestTaskDto updatedTaskDto) {
        Task task = findTaskById(id);
        Optional<TaskCategory> optionalTaskCategory = taskCategoryRepository.findByName(updatedTaskDto.getTaskType());
        if (!optionalTaskCategory.isPresent()) {
            throw new TaskCategoryNotFoundException("Category name not found");
        }
        task.setTitle(updatedTaskDto.getTitle());
        task.setTaskCategory(optionalTaskCategory.get());
        task.setCompleted(updatedTaskDto.isCompleted());
        task.setDate(updatedTaskDto.getDate());
        task.setNotes(updatedTaskDto.getNotes());
        return taskRepository.save(task);
    }

    public void deleteTask(Integer id) {
        try {
            taskRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new TaskNotFoundException("Task not found");
        }
    }
}






