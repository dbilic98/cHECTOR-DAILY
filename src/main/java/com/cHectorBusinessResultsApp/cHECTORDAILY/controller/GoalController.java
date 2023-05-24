package com.cHectorBusinessResultsApp.cHECTORDAILY.controller;

import com.cHectorBusinessResultsApp.cHECTORDAILY.controller.request.RequestGoalDto;
import com.cHectorBusinessResultsApp.cHECTORDAILY.controller.response.ResponseGoalDto;
import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.model.Goal;
import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/goals")
public class GoalController {
    private final GoalService goalService;

    @Autowired
    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseGoalDto createGoal(@Valid @RequestBody RequestGoalDto requestGoalDto) {
        Goal createdGoal = goalService.createGoal(requestGoalDto);
        return new ResponseGoalDto(
                createdGoal.getTitle(),
                createdGoal.getGoalCategory().getName(),
                createdGoal.getDate(),
                createdGoal.getNotes(),
                false);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseGoalDto updateGoal(@Valid @PathVariable("id") Integer id, @RequestBody RequestGoalDto requestGoalDto) {
        Goal updateGoal = goalService.updateGoal(id, requestGoalDto);
        return new ResponseGoalDto(
                updateGoal.getTitle(),
                updateGoal.getGoalCategory().getName(),
                updateGoal.getDate(),
                updateGoal.getNotes(),
                updateGoal.isCompleted());
    }

    @GetMapping("/{id}")
    public ResponseGoalDto findGoalById(@PathVariable Integer id) {
        Goal goal = goalService.findGoalById(id);
        return new ResponseGoalDto(
                goal.getTitle(),
                goal.getGoalCategory().getName(),
                goal.getDate(),
                goal.getNotes(),
                goal.isCompleted()
        );
    }

    @GetMapping
    public List<ResponseGoalDto> findAllGoals() {
        List<Goal> goals = goalService.findAllGoals();
        List<ResponseGoalDto> responseGoalDtoArrayList = new ArrayList<>();

        for (Goal goal : goals) {
            ResponseGoalDto responseGoalDto = new ResponseGoalDto(
                    goal.getTitle(),
                    goal.getGoalCategory().getName(),
                    goal.getDate(),
                    goal.getNotes(),
                    goal.isCompleted()
            );
            responseGoalDtoArrayList.add(responseGoalDto);
        }
        return responseGoalDtoArrayList;
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGoal(@PathVariable("id") Integer id) {
        goalService.deleteGoal(id);
    }
}
