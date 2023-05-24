package com.cHectorBusinessResultsApp.cHECTORDAILY.domain.repository;

import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Integer> {

}
