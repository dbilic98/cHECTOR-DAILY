package com.cHectorBusinessResultsApp.cHECTORDAILY.domain.repository;

import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GoalRepository extends JpaRepository<Goal, UUID> {

}
