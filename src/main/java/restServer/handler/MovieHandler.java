package restServer.handler;

import com.google.gson.Gson;
import dbal.repository.Repository;
import dbal.specification.GenreSpecification;
import models.Actor;
import models.Genre;
import models.Movie;;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import restServer.reply.Reply;
import restServer.reply.Status;
import restServer.request.FrontendMovie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MovieHandler {
    private Repository<Movie> movieRepository = new Repository<Movie>(Movie.class);
    private Repository<Actor> actorRepository = new Repository<Actor>(Actor.class);
    private Repository<Genre> genreRepository = new Repository<>(Genre.class);
    Gson gson = new Gson();

    public Reply newMovie(FrontendMovie frontendMovie){
        Movie movie = new Movie();
        ArrayList<Actor> actors = new ArrayList<>();
        ArrayList<Genre> genres = new ArrayList<>();

        Session session = actorRepository.openSession();
        for (Integer actorId : frontendMovie.getActors()) {
            Actor actor = (Actor) session.get(Actor.class, actorId);
            actors.add(actor);
        }

        Session sessionGenre = genreRepository.openSession();
        for (Integer genreId : frontendMovie.getGenres()) {
           Genre temp = (Genre) sessionGenre.get(Genre.class, genreId);
           genres.add(temp);
        }

        movie.setGenres(genres);
        movie.setActors(actors);
        movie.setName(frontendMovie.getName());
        movie.setDescription(frontendMovie.getDescription());
        movie.setDuration(frontendMovie.getDuration());
        movie.setBgImage(frontendMovie.getBgImage());

        movieRepository.save(movie);
        return new Reply(Status.OK, "Yippie");

    }

    public Reply getAllMovies() {

        Session session = movieRepository.openSession();
        List queryResult = session.createCriteria(Movie.class).list();;
        ArrayList<Movie> resultList = new ArrayList<>();
        for (Object result : queryResult) {
            Movie movie = (Movie) result;
            resultList.add(movie);
        }
        System.out.println(gson.toJson(resultList));
        return new Reply(Status.OK, gson.toJson(resultList));
    }
}
