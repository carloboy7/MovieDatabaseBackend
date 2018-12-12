package dbal.repository;
import models.Actor;

public class Repository<T> extends AbstractRepository<T, Integer> {
    private final Class<T> type;
    public Repository(Class<T> type){
        this.type = type;
    }
    @Override
    public Class<T> getDomainClass() {
        return type;
    }
}
