package com.axonactive.footballtournament.member;

import java.net.URI;
import java.util.List;
import java.util.Objects;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import com.axonactive.footballtournament.member.player.Player;

@Path("members")
@Stateless
public class MemberResource {
    @Inject
    MemberService memberService;

    @Context
    UriInfo uriInfo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addMember(@Valid Player newMember) {
        try {
            memberService.add(newMember);
            URI uri = uriInfo.getAbsolutePathBuilder().path(Integer.toString(newMember.getId())).build();
            return Response.created(uri).entity(newMember).build();
        } catch (Exception e) {
            return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMembers(@DefaultValue("") @QueryParam("company") String companyId) {
        if (companyId.isEmpty()) {
            return Response.ok(memberService.getAll()).build();
        } else {
            List<Member> members = memberService.getMemberFromCompany(companyId);
            return Response.ok(members).build();
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMemberById(@PathParam("id") Integer memberId) {
        Player member = memberService.getById(memberId);
        if (Objects.isNull(member)) {
            return Response.status(Status.NOT_FOUND).entity("Member not found").build();
        }
        return Response.ok(member).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteMemberById(@PathParam("id") Integer memberId) {
        boolean deleted = memberService.delete(memberId);
        if (deleted) {
            return Response.ok("Member deleted").build();
        }
        return Response.status(Status.NOT_FOUND).entity("Member not found").build();
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMember(@PathParam("id") Integer memberId, @Valid Player updatedMember) {
        Player response = memberService.update(memberId, updatedMember);

        if (response != null) {
            return Response.ok(response).build();
        } else {
            return Response.status(Status.NOT_FOUND).entity("Member not found").build();
        }
    }

    @GET
    @Path("from-company/{company_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMemberFromCompany(@PathParam("company_id") String companyId) {
        List<Member> members = memberService.getMemberFromCompany(companyId);

        return Response.ok(members).build();
    }
}
