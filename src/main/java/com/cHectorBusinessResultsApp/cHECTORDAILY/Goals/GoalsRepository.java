package com.cHectorBusinessResultsApp.cHECTORDAILY.Goals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GoalsRepository extends JpaRepository<Goals, Long> {

    @Query("SELECT s FROM Goals s WHERE s.goalTitle=?1")
    Optional<Goals> findGoalsByGoalTitle(String title);

}
