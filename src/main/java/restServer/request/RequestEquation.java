package restServer.request;

import java.util.ArrayList;

public class RequestEquation {
    String equation;
    ArrayList<RequestSolution> requestSolutions= new ArrayList<>();

    public String getEquation() {
        return equation;
    }

    public ArrayList<RequestSolution> getRequestSolutions() {
        return requestSolutions;
    }
}
