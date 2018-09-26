package restServer.handler;

import dbal.repository.EquationRepository;
import models.Equation;
import models.Solution;
import restServer.reply.Reply;
import restServer.reply.Status;

import java.util.ArrayList;

public class EquationHandler {
    EquationRepository equationRepository = new EquationRepository();

    public Reply getEquation(){
        Equation equation = new Equation();
        Solution solution = new Solution();
        solution.setId(1);
        solution.setSolution("hoi");
        ArrayList<Solution> solutions = new ArrayList<>();
        solutions.add(solution);
        equation.setId(2);
        equation.setSolution(solutions);
        equation.setEquation("test");
        equationRepository.save(equation);


        return new Reply(Status.OK, "Yippie");

    }
}
