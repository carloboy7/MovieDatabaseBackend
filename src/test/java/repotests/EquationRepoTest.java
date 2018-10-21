package repotests;

import dbal.repository.EquationRepository;
import models.Equation;
import models.Solution;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.logging.Level;

import static org.junit.Assert.assertEquals;

public class EquationRepoTest extends AbstractRepoTest {
    private EquationRepository repo;
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void TestInitialize() {
        repo = new EquationRepository();
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
    }


    private Equation insertOneValidEquation() {
        Equation equation = new Equation();
        equation.setEquation("testEquation");
        Solution solution = new Solution();
        solution.setSolution("solution to testEquation");
        solution.setEquation(equation);
        ArrayList<Solution> solutions = new ArrayList<>();
        solutions.add(solution);
        equation.setSolutions(solutions);
        repo.save(equation);
        return equation;
    }

    @Test
    public void testSaveValid() {
        int before = repo.findAll().size();
        insertOneValidEquation();
        int after = repo.findAll().size();
        assertEquals(before + 1, after);
    }

    @Test
    public void testFindAll() {
        int repoSize = repo.findAll().size();
        insertOneValidEquation();
        assertEquals(repoSize + 1, repo.findAll().size());

        for (int i = 0; i < 10; i++) {
            insertOneValidEquation();
        }
        int result = repo.findAll().size();
        assertEquals(repoSize + 11, result);
    }

    @Test
    public void testFindOneNull() {
        Equation result = repo.findOne(1);
        assertEquals(null, result);
    }

    @Test
    public void testDelete() {
        Equation equation = insertOneValidEquation();
        int repoSize = repo.findAll().size();

        repo.delete(equation);
        int repoSizeAfter = repo.findAll().size();
        assertEquals(repoSize - 1, repoSizeAfter);
    }

}
