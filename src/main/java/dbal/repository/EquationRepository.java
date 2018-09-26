package dbal.repository;

import models.Equation;

public class EquationRepository extends AbstractRepository<Equation, Integer> {
    @Override
    public Class<Equation> getDomainClass() {
        return Equation.class;
    }
}
