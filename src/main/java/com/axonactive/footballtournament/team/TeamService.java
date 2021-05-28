package com.axonactive.footballtournament.team;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.ValidationException;
import javax.ws.rs.NotFoundException;

import com.axonactive.footballtournament.member.player.Player;

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

    public Team addPlayer(Integer teamId, Integer playerId) {
        Team team = teamManager.find(Team.class, teamId);
        if(!Objects.isNull(team)) {
            Player addedPlayer = teamManager.find(Player.class, playerId);
            if(!Objects.isNull(addedPlayer)) {
                team.addPlayer(addedPlayer);

                teamManager.merge(team);
                return team;
            }
            else {
                throw new NotFoundException("Player not found");
            }
        }
        else {
            throw new NotFoundException("Team not found");
        }
    }

    public List<Player> getTeamPlayers(Integer teamId) {
        Team team = teamManager.find(Team.class, teamId);
        if(!Objects.isNull(team)) { 
            return team.getPlayers();
        }
        else {
            throw new NotFoundException("Team not found");
        }
    }

}
