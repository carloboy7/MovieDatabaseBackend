package dbal.repository;
import models.Solution;

public class SolutionRepository extends AbstractRepository<Solution, Integer> {
    @Override
    public Class<Solution> getDomainClass() {
        return Solution.class;
    }
}
