package com.cHectorBusinessResultsApp.cHECTORDAILY.Goals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GoalsService {

    private final GoalsRepository goalsRepository;

    @Autowired
    public GoalsService(GoalsRepository goalsRepository) {
        this.goalsRepository = goalsRepository;
    }

    public List<Goals> getGoals(){
        return goalsRepository.findAll();
    }

    public void addNewGoal(Goals goal) {
         Optional<Goals> goalsByGoalTitle = goalsRepository.findGoalsByGoalTitle(goal.getGoalTitle());
         if (goalsByGoalTitle.isPresent()){
             throw new IllegalStateException("Zadati Goal je već postavljen!");
         }
         goalsRepository.save(goal);
        System.out.println(goal);
    }

    public void deleteGoal(Long id) {
        goalsRepository.findById(id);
         boolean exists = goalsRepository.existsById(id);
         if (!exists){
             throw new IllegalStateException("Goal ne postoji");
         }
         goalsRepository.deleteById(id);
    }

    @Transactional
    public void updateGoal(Long goalId,String goalBody) {
        Goals goal = goalsRepository.findById(goalId).
                orElseThrow(()-> new IllegalStateException(
                        "Odabrani Goal ne postoji!"
                ));
        if (goalBody!=null && goalBody.length()>0 && !Objects.equals(goal.getGoalBody(),goalBody)){
            goal.setGoalBody(goalBody);
        }
    }
}
