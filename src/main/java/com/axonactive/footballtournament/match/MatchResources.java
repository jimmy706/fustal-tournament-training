package com.axonactive.footballtournament.match;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("matches")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MatchResources {
    
    @Inject
    MatchService matchService;


    @Path("generate")
    @POST
    public Response generateMatches(String location) {
        matchService.generateMatches(location);
        return Response.ok("Matches generated").build();
    }



    @GET
    public Response getAll() {
        List<Match> matches = matchService.getAll();

        return Response.ok(matches).build();
    }

    
}
