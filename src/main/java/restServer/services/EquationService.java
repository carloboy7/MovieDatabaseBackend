package restServer.services;

import com.google.gson.Gson;
import restServer.handler.EquationHandler;
import restServer.reply.Reply;
import restServer.reply.Status;
import restServer.request.RequestEquation;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/equation")
    public class EquationService {

        private EquationHandler equationHandler = new EquationHandler();
        @POST
        @Consumes("application/json")
        @Path("/submit")
        public Response submit(String data) {
            Gson gson = new Gson();
            RequestEquation equation = gson.fromJson(data, RequestEquation.class);
            Reply reply = equationHandler.execEquation(equation);
            System.out.println(reply.getMessage());
            return Response.status(reply.getStatus().getCode())
                    .entity(reply.getMessage()).build();
        }

        @GET
        @Consumes(MediaType.TEXT_PLAIN)
        @Path("/get")
        public Response findEquation(@DefaultValue("") @QueryParam("equation") String equation, @Context UriInfo uriInfo){

            Reply reply = equationHandler.findEquation(equation);
            return Response.status(reply.getStatus().getCode())
                    .entity(reply.getMessage()).build();
        }

        @GET
        @Consumes(MediaType.TEXT_PLAIN)
        @Path("/recommended")
        public Response getRecommended(@DefaultValue("") @QueryParam("entry") String entry, @Context UriInfo uriInfo){

            Reply reply = equationHandler.getRecommended(entry);
            return Response.status(reply.getStatus().getCode())
                    .entity(reply.getMessage()).build();
        }

    }
