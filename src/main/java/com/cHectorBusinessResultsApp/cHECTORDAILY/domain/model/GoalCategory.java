package com.cHectorBusinessResultsApp.cHECTORDAILY.domain.model;

import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.enumeration.GoalType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "erp_administration", name = "erp_kategorije_goala")
public class GoalCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private GoalType name;

    @JsonIgnore
    @OneToMany(mappedBy = "goalCategory")
    private List<Goal> goals;

    public GoalCategory() {
    }

    public GoalCategory(GoalType name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GoalType getName() {
        return name;
    }

    public void setName(GoalType name) {
        this.name = name;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

}

