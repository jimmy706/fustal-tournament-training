package com.axonactive.footballtournament.company;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.axonactive.footballtournament.team.Team;
import com.axonactive.footballtournament.team.TeamService;


public class CompanyService {
    
    @PersistenceContext
    EntityManager companyManager;

    @Inject
    TeamService teamService;

    public void add(Company newCompany) {
        companyManager.persist(newCompany);
        teamService.add(new Team(newCompany.getName(), newCompany.getId()));
    }

    public List<Company> getAll() {
        TypedQuery<Company> query = companyManager.createNamedQuery(Company.GET_ALL_QUERY, Company.class);
        return query.getResultList();
    }

    public boolean deleteCompany(Integer keyId) {
        Company company = companyManager.find(Company.class, keyId);
        if(company != null) {
            companyManager.remove(company);
            return true;
        }
        else {
            return false;
        }
    }

    public Company getById(String companyId) {
            return companyManager.
                createNamedQuery(Company.GET_BY_ID, Company.class)
                .setParameter("companyId", companyId)
                .getSingleResult();
      
    }
    
}
