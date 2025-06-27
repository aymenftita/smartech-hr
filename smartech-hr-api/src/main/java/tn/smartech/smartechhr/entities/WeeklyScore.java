package tn.smartech.smartechhr.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeeklyScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "operator_id")
    private Employee operator;

    @OneToOne
    private WeeklyAssignment week;
    private double score;

    @ManyToOne
    @JoinColumn(name = "evaluated_by")
    private Employee evaluatedBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }


    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Employee getEvaluatedBy() {
        return evaluatedBy;
    }

    public void setEvaluatedBy(Employee evaluatedBy) {
        this.evaluatedBy = evaluatedBy;
    }

    public WeeklyScore(Employee operator, double score, Employee evaluatedBy) {
        this.operator = operator;
        this.score = score;
        this.evaluatedBy = evaluatedBy;
    }
}