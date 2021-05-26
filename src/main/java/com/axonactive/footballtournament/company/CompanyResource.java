package com.axonactive.footballtournament.company;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

@Path("companies")
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class CompanyResource {
    @Inject
    CompanyService companyService;

    @Context
    UriInfo uriInfo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(@Valid Company newCompany) {
        try {
            companyService.add(newCompany);
            URI uri = uriInfo.getAbsolutePathBuilder().path(newCompany.getId()).build();

            return Response.created(uri).entity(newCompany).build();
        }      
        catch(ConstraintViolationException e) {
            return Response.status(Status.BAD_REQUEST).entity(CompanyMessage.COMPANY_ID_EXISTED).build();
        }
    }

    @GET
    public List<Company> getAll() {
        return companyService.getAll();
    }

    @GET
    @Path("{company_id}")
    public Response getById(@PathParam("company_id") String companyId) {
        try {
            Optional<Company> companyOpt = Optional.of(companyService.getById(companyId));
            if(companyOpt.isPresent()) {
                return Response.ok(companyOpt.get()).build();
            }
            else {
                return Response.status(Status.NOT_FOUND).entity(CompanyMessage.COMPANY_NOT_FOUND).build();
            }
        }
        catch(NoResultException e) {
            /**
             * Handle company not found
             */
            return Response.status(Status.NOT_FOUND).entity(CompanyMessage.COMPANY_NOT_FOUND).build();            
        }
    }

    @Path("{companyId}")
    @DELETE
    public Response deleteCompany(@PathParam("{companyId}") Integer companyId) {
        boolean deleted = companyService.deleteCompany(companyId);

        if (deleted) {
            return Response.ok("Company delted").build();
        } else {
            return Response.status(Status.NOT_FOUND).entity("Company not found").build();
        }
    }

}
