package restServer.services;

import com.google.gson.Gson;
import restServer.handler.EquationHandler;
import restServer.reply.Reply;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

    @Path("/equation")
    public class EquationService {

        private EquationHandler equationHandler = new EquationHandler();
        @GET
        @Consumes("application/json")
        @Path("/submit")
        public Response submit(String data) {
            Gson gson = new Gson();

            Reply reply = equationHandler.getEquation();

            return Response.status(reply.getStatus().getCode())
                    .entity(reply.getMessage()).build();
        }

    }
