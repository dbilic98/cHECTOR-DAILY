package com.cHectorBusinessResultsApp.cHECTORDAILY.domain.repository;

import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.enumeration.GoalType;
import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.model.GoalCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GoalCategoryRepository extends JpaRepository<GoalCategory, Integer> {
    Optional<GoalCategory> findByName(GoalType name);
}

