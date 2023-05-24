package com.cHectorBusinessResultsApp.cHECTORDAILY.domain.service;

import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.enumeration.GoalType;
import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.model.GoalCategory;
import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.repository.GoalCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GoalCategoryService {
    private final GoalCategoryRepository goalCategoryRepository;

    public GoalCategoryService(GoalCategoryRepository goalCategoryRepository) {
        this.goalCategoryRepository = goalCategoryRepository;
    }
    public Optional<GoalCategory> findByName(GoalType name) {
        return goalCategoryRepository.findByName(name);
    }
}
