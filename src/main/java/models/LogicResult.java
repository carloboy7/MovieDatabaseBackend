package models;

import java.util.ArrayList;
import java.util.List;


public class LogicResult {

    private String input;
    private List<String> results = new ArrayList<>();

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
    }

}
