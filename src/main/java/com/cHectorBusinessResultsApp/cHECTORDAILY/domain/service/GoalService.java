package com.cHectorBusinessResultsApp.cHECTORDAILY.domain.service;

import com.cHectorBusinessResultsApp.cHECTORDAILY.controller.request.RequestGoalDto;
import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.model.Goal;
import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.model.GoalCategory;
import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.repository.GoalRepository;
import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.repository.GoalCategoryRepository;
import com.cHectorBusinessResultsApp.cHECTORDAILY.exception.GoalCategoryNotFoundException;
import com.cHectorBusinessResultsApp.cHECTORDAILY.exception.GoalNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GoalService {
    public final GoalRepository goalRepository;
    public final GoalCategoryRepository goalCategoryRepository;

    @Autowired
    public GoalService(GoalRepository goalRepository, GoalCategoryRepository goalCategoryRepository) {
        this.goalRepository = goalRepository;
        this.goalCategoryRepository = goalCategoryRepository;
    }

    public List<Goal> findAllGoals() {
        return goalRepository.findAll();
    }

    public Goal findGoalById(UUID id) {
        Optional<Goal> optionalGoal = goalRepository.findById(id);
        if (!optionalGoal.isPresent()) {
            throw new GoalNotFoundException("Goal ID is not found");
        }
        return optionalGoal.get();
    }

    public Goal createGoal(RequestGoalDto requestGoalDto) {
        Optional<GoalCategory> optionalGoalCategory = goalCategoryRepository.findByName(requestGoalDto.getGoalType());
        if (!optionalGoalCategory.isPresent()) {
            throw new GoalCategoryNotFoundException("Category name not found!");
        }
        Goal goal = new Goal(
                requestGoalDto.getTitle(),
                requestGoalDto.getDate(),
                requestGoalDto.getNotes(),
                optionalGoalCategory.get());
        return goalRepository.save(goal);
    }

    public Goal updateGoal(UUID id, RequestGoalDto updatedGoalDto) {
        Goal goal = findGoalById(id);
        Optional<GoalCategory> optionalGoalCategory = goalCategoryRepository.findByName(updatedGoalDto.getGoalType());
        if (!optionalGoalCategory.isPresent()) {
            throw new GoalCategoryNotFoundException("Category name not found");
        }
        goal.setTitle(updatedGoalDto.getTitle());
        goal.setGoalCategory(optionalGoalCategory.get());
        goal.setCompleted(updatedGoalDto.isCompleted());
        goal.setDate(updatedGoalDto.getDate());
        goal.setNotes(updatedGoalDto.getNotes());
        return goalRepository.save(goal);
    }

    public void deleteGoal(UUID id) {
        try {
            goalRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new GoalNotFoundException("Goal not found");
        }
    }
}






