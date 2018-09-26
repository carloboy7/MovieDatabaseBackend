package models;

import java.util.ArrayList;

public class Equation {
    int id;
    String equation;
    ArrayList<Solution> solution;

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

    public ArrayList<Solution> getSolution() {
        return solution;
    }

    public void setSolution(ArrayList<Solution> solution) {
        this.solution = solution;
    }
}
