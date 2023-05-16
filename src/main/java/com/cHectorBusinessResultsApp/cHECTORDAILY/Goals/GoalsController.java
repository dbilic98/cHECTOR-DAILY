package com.cHectorBusinessResultsApp.cHECTORDAILY.Goals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/cHector")
public class GoalsController {

    private final GoalsService goalsService;

    @Autowired
    public GoalsController(GoalsService goalsService) {
        this.goalsService = goalsService;
    }

    @GetMapping
    public List<Goals> getStudent(){
        return goalsService.getGoals();
    };

    @PostMapping
    public void uploadNewGoal(@RequestBody Goals goal)
    {
        goalsService.addNewGoal(goal);
    }

    @DeleteMapping(path="{goalId}")
    public void deleteGoal(@PathVariable("goalId") Long id){
        goalsService.deleteGoal(id);
    }

    @PutMapping(path="{goalId}")
    public void updateGoal(@PathVariable("goalId") Long goalId, @RequestParam(required = false) String goalBody){
        goalsService.updateGoal(goalId,goalBody);
    }
}
