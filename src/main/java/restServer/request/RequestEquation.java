package restServer.request;

import java.util.ArrayList;

public class RequestEquation {
    String equation;
    ArrayList<RequestSolution> requestSolutions= new ArrayList<>();

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public ArrayList<RequestSolution> getRequestSolutions() {
        return requestSolutions;
    }

    public void setRequestSolutions(ArrayList<RequestSolution> requestSolutions) {
        this.requestSolutions = requestSolutions;
    }
}
