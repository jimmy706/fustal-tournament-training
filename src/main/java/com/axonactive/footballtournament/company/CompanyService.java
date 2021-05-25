package com.axonactive.footballtournament.company;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


public class CompanyService {
    
    @PersistenceContext
    EntityManager companyManager;

    public void add(Company newCompany) {
        companyManager.persist(newCompany);
    }

    public List<Company> getAll() {
        TypedQuery<Company> query = companyManager.createNamedQuery(Company.GET_ALL_QUERY, Company.class);
        return query.getResultList();
    }
    
}
