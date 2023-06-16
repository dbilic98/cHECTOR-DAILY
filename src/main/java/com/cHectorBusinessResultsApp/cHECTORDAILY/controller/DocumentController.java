package com.cHectorBusinessResultsApp.cHECTORDAILY.controller;

import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;
@RestController
@RequestMapping("/documents")
public class DocumentController {

        private final DocumentService documentService;

        @Autowired
        public DocumentController(DocumentService documentService) {
            this.documentService = documentService;
        }

        @GetMapping("/count-by-year")
        public ResponseEntity<Map<Integer, Long>> countDocumentsByYear() {
            Map<Integer, Long> result = documentService.countDocumentsByYear();
            return ResponseEntity.ok(result);
        }

        @GetMapping("/prices-by-year")
        public ResponseEntity<Map<Integer, BigDecimal>> getPricesByYear() {
            Map<Integer, BigDecimal> result = documentService.calculatePricesByYear();
            return ResponseEntity.ok(result);
        }
    }


