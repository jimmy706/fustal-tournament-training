package com.axonactive.footballtournament.match;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class MatchResultsService{
    @PersistenceContext
    EntityManager matchResultManager;

    public void add(MatchResult matchResult) {
        matchResultManager.persist(matchResult);
    }


}
