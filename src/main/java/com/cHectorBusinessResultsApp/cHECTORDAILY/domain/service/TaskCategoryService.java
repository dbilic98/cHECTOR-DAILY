package com.cHectorBusinessResultsApp.cHECTORDAILY.domain.service;

import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.enumeration.TaskType;
import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.model.TaskCategory;
import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.repository.TaskCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskCategoryService {
    private final TaskCategoryRepository taskCategoryRepository;

    public TaskCategoryService(TaskCategoryRepository taskCategoryRepository) {
        this.taskCategoryRepository = taskCategoryRepository;
    }
    public Optional<TaskCategory> findByName(TaskType name) {
        return taskCategoryRepository.findByName(name);
    }
}
