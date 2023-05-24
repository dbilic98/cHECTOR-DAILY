package com.cHectorBusinessResultsApp.cHECTORDAILY.domain.repository;

import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.enumeration.TaskType;
import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.model.TaskCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskCategoryRepository extends JpaRepository<TaskCategory, Integer> {
    Optional<TaskCategory> findByName(TaskType name);
}

