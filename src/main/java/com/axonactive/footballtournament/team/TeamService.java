package com.axonactive.footballtournament.team;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.ValidationException;

public class TeamService {
    
    @PersistenceContext
    EntityManager teamManager;

    public void add(Team newTeam) {
        validateTeam(newTeam);
        teamManager.persist(newTeam);
    }

    public List<Team> getAll() {
        TypedQuery<Team> query = teamManager.createNamedQuery(Team.GET_ALL_QUERY, Team.class);
        return query.getResultList();
    }

    public boolean delete(Integer teamId) {
        Team deletedTeam = teamManager.find(Team.class, teamId);
        if(deletedTeam == null) {
            return false;
        }
        return true;
    }

    public void validateTeam(Team team) {
        if(Objects.isNull(team)){
            throw new IllegalArgumentException("Team is missing");
        }
        else if(!team.validate()) {
            throw new ValidationException("Some field is missing or wrong");
        }
    }

}
