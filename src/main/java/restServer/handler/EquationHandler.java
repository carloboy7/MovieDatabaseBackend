package restServer.handler;

import dbal.repository.EquationRepository;
import dbal.repository.SolutionRepository;
import models.Equation;
import models.Solution;
import restServer.reply.Reply;
import restServer.reply.Status;

import java.util.*;

public class EquationHandler {
    SolutionRepository solutionRepository = new SolutionRepository();

    public Reply saveEquation(){
        Equation equation = new Equation();
        Solution solution = new Solution();
        Solution solution1 = new Solution();
        solution1.setSolution("hoi 1");
        solution.setSolution("hoi");
        equation.setEquation("test");
        solution.setEquation(equation);
        solution1.setEquation(equation);
        solutionRepository.save(solution);
        solutionRepository.save(solution1);


        return new Reply(Status.OK, "Yippie");

    }

    public Reply findEquation(String equation) {
        return new Reply(Status.OK, equation);
    }

    public Reply getRecommended(String entry) {
        return new Reply(Status.OK, entry);
    }
}
