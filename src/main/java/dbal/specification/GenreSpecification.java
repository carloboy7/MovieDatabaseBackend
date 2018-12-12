package dbal.specification;

import org.eclipse.persistence.internal.oxm.schema.model.Restriction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public abstract class GenreSpecification {
    public static Specifiable getByGenreId(int genreId){
        return new AbstractSpecification() {
            @Override
            public Criterion toCriterion() {
                return Restrictions.eq("Genre.Genre_id", genreId);
            }
        };
    }
}
