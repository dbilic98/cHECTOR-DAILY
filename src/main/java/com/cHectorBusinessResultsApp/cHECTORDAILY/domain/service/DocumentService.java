package com.cHectorBusinessResultsApp.cHECTORDAILY.domain.service;

import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Map<Integer, Long> countDocumentsByYear() {
        List<Object[]> countByYearList = documentRepository.countByYear();

        Map<Integer, Long> result = new HashMap<>();
        for (Object[] countByYear : countByYearList) {
            int year = (int) countByYear[0];
            long count = (long) countByYear[1];
            result.put(year, count);
        }

        return result;
    }

    public Map<Integer, BigDecimal> calculatePricesByYear() {
        List<Object[]> sumPricesByYearList = documentRepository.sumPricesByYear();
        Map<Integer, BigDecimal> result = new HashMap<>();
        for (Object[] sumPricesByYear : sumPricesByYearList) {
            int year = (int) sumPricesByYear[0];
            BigDecimal priceSum = BigDecimal.valueOf((double) sumPricesByYear[1]);
            result.put(year, priceSum);
        }
        return result;
    }

}
