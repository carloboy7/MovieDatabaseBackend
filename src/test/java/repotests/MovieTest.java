package repotests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dbal.repository.Repository;
import models.Actor;
import models.Genre;
import models.Movie;
import org.hibernate.Session;
import org.junit.Test;
import restServer.request.FrontendMovie;
import restServer.services.EquationService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest extends AbstractRepoTest {
    private EquationService service = new EquationService();
    private Repository<Actor> actorRepository = new Repository<Actor>(Actor.class);
    private Repository<Genre> genreRepository = new Repository<>(Genre.class);
    private Repository<Movie> movieRepository = new Repository<Movie>(Movie.class);

    @Test
    public void testActors() {
        String output = (String) service.getActors().getEntity();
        Gson gson = new Gson();
        List<Actor> actors = gson.fromJson(output, new TypeToken<List<Actor>>(){}.getType());

        Session session = actorRepository.openSession();
        List queryResult = session.createCriteria(Actor.class).list();

        assertEquals(actors.size(), queryResult.size());
    }

    @Test
    public void testGenres() {
        String output = (String) service.getGenres().getEntity();
        Gson gson = new Gson();
        List<Actor> genres = gson.fromJson(output, new TypeToken<List<Genre>>(){}.getType());

        Session session = genreRepository.openSession();
        List queryResult = session.createCriteria(Genre.class).list();

        assertEquals(genres.size(), queryResult.size());
    }

    @Test
    public void testCreationMovie(){
        FrontendMovie movie = new FrontendMovie();
        movie.setName("TEST");
        movie.setDuration(10d);
        movie.setDescription("Test movie");
        movie.setActors(new ArrayList<>());
        movie.setGenres(new ArrayList<>());
        Session session = movieRepository.openSession();

        int start = session.createCriteria(Movie.class).list().size();

        Gson gson = new Gson();
        String output = (String) service.submit(gson.toJson(movie)).getEntity();

        assertEquals(++start, session.createCriteria(Movie.class).list().size());
    }
}
