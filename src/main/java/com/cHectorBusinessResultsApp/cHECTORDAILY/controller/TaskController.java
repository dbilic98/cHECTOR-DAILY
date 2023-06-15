package com.cHectorBusinessResultsApp.cHECTORDAILY.controller;

import com.cHectorBusinessResultsApp.cHECTORDAILY.controller.request.RequestTaskDto;
import com.cHectorBusinessResultsApp.cHECTORDAILY.controller.response.ResponseTaskDto;
import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.model.Task;
import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseTaskDto createTask(@Valid @RequestBody RequestTaskDto requestTaskDto) {
        Task createdTask = taskService.createTask(requestTaskDto);
        return new ResponseTaskDto(
                createdTask.getTitle(),
                createdTask.getTaskCategory().getName(),
                createdTask.getDate(),
                createdTask.getNotes(),
                false);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseTaskDto updateTask(@Valid @PathVariable("id") UUID id, @RequestBody RequestTaskDto requestTaskDto) {
        Task updatedTask = taskService.updateTask(id, requestTaskDto);
        return new ResponseTaskDto(
                updatedTask.getTitle(),
                updatedTask.getTaskCategory().getName(),
                updatedTask.getDate(),
                updatedTask.getNotes(),
                updatedTask.isCompleted());
    }

    @GetMapping("/{id}")
    public ResponseTaskDto findTaskById(@PathVariable UUID id) {
        Task task = taskService.findTaskById(id);
        return new ResponseTaskDto(
                task.getTitle(),
                task.getTaskCategory().getName(),
                task.getDate(),
                task.getNotes(),
                task.isCompleted()
        );
    }

    @GetMapping
    public List<ResponseTaskDto> findAllTasks() {
        List<Task> tasks = taskService.findAllTasks();
        List<ResponseTaskDto> responseTaskDtoArrayList = new ArrayList<>();

        for (Task task : tasks) {
            ResponseTaskDto responseTaskDto = new ResponseTaskDto(
                    task.getTitle(),
                    task.getTaskCategory().getName(),
                    task.getDate(),
                    task.getNotes(),
                    task.isCompleted()
            );
            responseTaskDtoArrayList.add(responseTaskDto);
        }
        return responseTaskDtoArrayList;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable("id") UUID id) {
        taskService.deleteTask(id);
    }
}
