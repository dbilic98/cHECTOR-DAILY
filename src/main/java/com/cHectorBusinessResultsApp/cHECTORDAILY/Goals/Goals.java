package com.cHectorBusinessResultsApp.cHECTORDAILY.Goals;

import com.cHectorBusinessResultsApp.cHECTORDAILY.GoalsKategorije.GoalsKategorije;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "goals")
public class Goals {
    @Id
    @SequenceGenerator(
            name = "goals_sequence",
            sequenceName = "goals_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "goals_sequence"
    )
    @Column(name="id")
    private Integer id;
    @Column(name = "goal_title")
    private String goalTitle;
    @Column(name = "goal_date")
    private LocalDate goalDate;
    @Column(name="goal_body")
    private String goalBody;
    @Column(name="is_completed")
    private boolean isCompleted;

    @ManyToOne
    @JoinColumn(name = "goals_kategorije_id", nullable = false)
    private GoalsKategorije goalsKategorije;

    public Goals() {
    }

    public Goals(Integer id, String goalTitle, LocalDate goalDate, String goalBody, boolean isCompleted, GoalsKategorije goalsKategorije) {
        this.id = id;
        this.goalTitle = goalTitle;
        this.goalDate = goalDate;
        this.goalBody = goalBody;
        this.isCompleted = isCompleted;
        this.goalsKategorije = goalsKategorije;
    }

    public Goals(String goalTitle, LocalDate goalDate, String goalBody, boolean isCompleted, GoalsKategorije goalsKategorije) {
        this.goalTitle = goalTitle;
        this.goalDate = goalDate;
        this.goalBody = goalBody;
        this.isCompleted = isCompleted;
        this.goalsKategorije = goalsKategorije;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoalTitle() {
        return goalTitle;
    }

    public void setGoalTitle(String goalTitle) {
        this.goalTitle = goalTitle;
    }

    public LocalDate getGoalDate() {
        return goalDate;
    }

    public void setGoalDate(LocalDate goalDate) {
        this.goalDate = goalDate;
    }

    public String getGoalBody() {
        return goalBody;
    }

    public void setGoalBody(String goalBody) {
        this.goalBody = goalBody;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public GoalsKategorije getGoalsKategorije() {
        return goalsKategorije;
    }

    public void setGoalsKategorije(GoalsKategorije goalsKategorije) {
        this.goalsKategorije = goalsKategorije;
    }

    @Override
    public String toString() {
        return "Goals{" +
                "id=" + id +
                ", goalTitle='" + goalTitle + '\'' +
                ", goalDate=" + goalDate +
                ", goalBody='" + goalBody + '\'' +
                ", isCompleted=" + isCompleted +
                ", goalsKategorije=" + goalsKategorije +
                '}';
    }
}
