package com.cHectorBusinessResultsApp.cHECTORDAILY.GoalsKategorije;

import com.cHectorBusinessResultsApp.cHECTORDAILY.Goals.Goals;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class GoalsKategorije {
    @javax.persistence.Id
    @SequenceGenerator(
            name = "kategorije_sequence",
            sequenceName = "kategorije_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "kategorije_sequence"
    )
    private Integer Id;

   @Enumerated(EnumType.ORDINAL)
    private GoalType name;
    @JsonIgnore
    @OneToMany(mappedBy = "goalsKategorije")
    private List<Goals> goals;

    public GoalsKategorije() {
    }

    public GoalsKategorije(Integer id, GoalType name, List<Goals> goals) {
        Id = id;
        this.name = name;
        this.goals = goals;
    }

    public GoalsKategorije(GoalType name, List<Goals> goals) {
        this.name = name;
        this.goals = goals;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public GoalType getName() {
        return name;
    }

    public void setName(GoalType name) {
        this.name = name;
    }

    public List<Goals> getGoals() {
        return goals;
    }

    public void setGoals(List<Goals> goals) {
        this.goals = goals;
    }

    @Override
    public String toString() {
        return "GoalsKategorije{" +
                "Id=" + Id +
                ", name=" + name +
                ", goals=" + goals +
                '}';
    }
}
