package com.axonactive.footballtournament.team;

import java.net.URI;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Stateless
@Path("teams")
public class TeamResource {
    
    @Inject
    TeamService teamService;

    @Context
    UriInfo uriInfo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTeam(Team newTeam) {
        teamService.add(newTeam);
        URI uri = uriInfo.getAbsolutePathBuilder().path(Integer.toString(newTeam.getId())).build();
        return Response.created(uri).entity(newTeam).build();
    }
}
