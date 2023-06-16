package com.cHectorBusinessResultsApp.cHECTORDAILY.domain.repository;

import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface DocumentRepository extends JpaRepository<Document, UUID> {
    @Query("SELECT YEAR(d.date) as year, COUNT(d) FROM Document d GROUP BY year")
    List<Object[]> countByYear();

    @Query("SELECT YEAR(d.date) as year, SUM(d.value) FROM Document d GROUP BY year")
    List<Object[]> sumPricesByYear();
}
