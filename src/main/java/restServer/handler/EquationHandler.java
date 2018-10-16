package restServer.handler;

import com.google.gson.Gson;
import dbal.repository.EquationRepository;
import dbal.repository.SolutionRepository;
import equationLogic.AccessLogic;
import models.Equation;
import models.LogicResult;
import models.Solution;
import restServer.reply.Reply;
import restServer.reply.Status;
import restServer.request.RequestEquation;
import restServer.request.RequestSolution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EquationHandler {
    private SolutionRepository solutionRepository = new SolutionRepository();
    EquationRepository equationRepository = new EquationRepository();
    Gson gson = new Gson();

    public Reply saveEquation(RequestEquation equation){
        Equation equation1 = new Equation();
        Solution solution = new Solution();
        Solution solution1 = new Solution();
        solution1.setSolution("hoi 1");
        solution.setSolution("hoi");
        equation1.setEquation("test");
        solution.setEquation(equation1);
        solution1.setEquation(equation1);
        List<Solution> solutions = new ArrayList<>();
        solutions.add(solution);
        solutions.add(solution1);
        equation1.setSolutions(solutions);
        equationRepository.save(equation1);
        solutionRepository.save(solution);
        solutionRepository.save(solution1);



        return new Reply(Status.OK, "Yippie");

    }

    public Reply execEquation(RequestEquation equation){
        AccessLogic accessLogic = new AccessLogic();
        LogicResult result = new LogicResult();
        try {
            result = gson.fromJson(accessLogic.UseLogic(equation.getEquation()), LogicResult.class);
            Equation equationResult = new Equation();
            equationResult.setEquation(equation.getEquation());
            equationRepository.save(equationResult);
            for(String solution : result.getResults()){
                Solution solutionResult = new Solution();
                solutionResult.setEquation(equationResult);
                solutionResult.setSolution(solution);
                solutionRepository.save(solutionResult);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Reply(Status.OK, result.getResults());
    }

    public Reply findEquation(String equation) {
        return new Reply(Status.OK, equation);
    }

    public Reply getRecommended(String entry) {
        return new Reply(Status.OK, entry);
    }
}
