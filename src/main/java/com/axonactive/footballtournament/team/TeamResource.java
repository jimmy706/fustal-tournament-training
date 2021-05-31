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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import com.axonactive.footballtournament.company.Company;
import com.axonactive.footballtournament.member.player.Player;

@Stateless
@Path("teams")

public class TeamResource {

    @Inject
    TeamService teamService;

    @Context
    UriInfo uriInfo;

    @Path("{team_id}/{player_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Response addPlayerToTeam(@PathParam("team_id") Integer teamId, @PathParam("player_id") Integer playerId) {
        System.out.println("Team id: " + teamId + " " + "Player id: " + playerId);

        try {
            Company team = teamService.addPlayer(teamId, playerId);

 
            System.out.println("package com.axonactive.footballtournament.team.addPlayerToTeam Response: \n" + team);

            return Response.ok(team).build();
        } catch (NotFoundException e) {
            return Response.status(Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch(IllegalArgumentException e) {
            return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @Path("{teamId}")
    @GET
    public Response getTeamPlayers(@PathParam("{teamId}") Integer teamId) {
        try {
            List<Player> players = teamService.getTeamPlayers(teamId);

            return Response.ok(players).build();
        } catch (NotFoundException e) {
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
