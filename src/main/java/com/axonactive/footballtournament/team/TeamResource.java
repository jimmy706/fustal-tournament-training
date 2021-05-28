package com.axonactive.footballtournament.team;

import java.net.URI;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import com.axonactive.footballtournament.member.player.Player;

@Stateless
@Path("teams")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeamResource {
    
    @Inject
    TeamService teamService;

    @Context
    UriInfo uriInfo;

    @GET
    public Response getTeamPlayers(Integer teamId) {
        try {
            List<Player> players = teamService.getTeamPlayers(teamId);

            return Response.ok(players).build();
        }
        catch(NotFoundException e) {
            return Response.status(Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @POST   
    public Response addTeam(Team newTeam) {
        teamService.add(newTeam);
        URI uri = uriInfo.getAbsolutePathBuilder().path(Integer.toString(newTeam.getId())).build();
        return Response.created(uri).entity(newTeam).build();
    }
}
