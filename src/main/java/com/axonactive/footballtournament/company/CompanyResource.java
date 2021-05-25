package com.axonactive.footballtournament.company;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("companies")
@Stateless
public class CompanyResource {
    @Inject
    CompanyService companyService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(Company newCompany) {
        companyService.add(newCompany);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Company> getAll(){
        return companyService.getAll();
    }
    

}
