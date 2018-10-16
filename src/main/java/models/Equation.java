package models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Equation")
public class Equation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Equation_ID", unique = true, nullable = false)
    int id;

    @NotNull
    String equation;

    @OneToMany(mappedBy="equation", cascade = {CascadeType.ALL, CascadeType.MERGE, CascadeType.PERSIST})
    private List<Solution> solutions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public List<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<Solution> solutions) {
        this.solutions = solutions;
    }
}
