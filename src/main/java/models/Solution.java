package models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Solution")
public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Solution_ID", unique = true, nullable = false)
    int id;

    @NotNull
    String solution;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    Equation equation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Equation getEquation() {
        return equation;
    }

    public void setEquation(Equation equation) {
        this.equation = equation;
    }
}
