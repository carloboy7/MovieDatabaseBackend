package restServer.services;

import com.google.gson.Gson;
import restServer.handler.MovieHandler;
import restServer.reply.Reply;
import restServer.request.FrontendMovie;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/api")
public class EquationService {

    private MovieHandler movieHandler = new MovieHandler();
    @POST
    @Consumes("application/json")
    @Path("/submit")
    public Response submit(String data) {
        Gson gson = new Gson();
        FrontendMovie movie = gson.fromJson(data, FrontendMovie.class);
        Reply reply = movieHandler.newMovie(movie);
        System.out.println(reply.getMessage());
        return Response.status(reply.getStatus().getCode())
                .entity(reply.getMessage()).build();
    }

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("/allMovies")
    public Response getRecommended(){

        Reply reply = movieHandler.getAllMovies();
        return Response.status(reply.getStatus().getCode())
                .entity(reply.getMessage()).build();
    }

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("/actors")
    public Response getActors(){

        Reply reply = movieHandler.getAllActors();
        return Response.status(reply.getStatus().getCode())
                .entity(reply.getMessage()).build();
    }

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("/genres")
    public Response getGenres(){

        Reply reply = movieHandler.getAllGenres();
        return Response.status(reply.getStatus().getCode())
                .entity(reply.getMessage()).build();
    }


}
