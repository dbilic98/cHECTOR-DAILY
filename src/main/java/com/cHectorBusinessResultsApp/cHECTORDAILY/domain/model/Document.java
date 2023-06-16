package com.cHectorBusinessResultsApp.cHECTORDAILY.domain.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(schema = "erp_administration", name = "erp_dokumenti")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "datum_dokumenta")
    private LocalDate date;

    @Column(name = "vrijednost_dokumenta_val")
    private Double value;

    public Document() {
    }

    public Document(LocalDate date, Double value) {
        this.date = date;
        this.value = value;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
