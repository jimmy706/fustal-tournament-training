package com.axonactive.footballtournament.match;

import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.axonactive.footballtournament.team.Team;

public class MatchService {

    @PersistenceContext
    EntityManager matchManager;

    @Inject
    MatchResultsService matchResultsService;

    public void generateMatches(String location) {
        
        TypedQuery<Team> queryTeams = matchManager.createNamedQuery(Team.GET_ALL_QUERY, Team.class);
        List<Team> registeredTeams = queryTeams.getResultList();

        for (int i = 1; i < registeredTeams.size(); i++) {
            int left = 0;
            int right = registeredTeams.size() - 1;
            int count = 1;

            while (left < right) {
                Team firstTeam = registeredTeams.get(left);
                Team secondTeam = registeredTeams.get(right);
                LocalDateTime startDateTime = LocalDateTime.now()
                        .plusDays(i)
                        .plusMinutes((count - 1) * 25);
                LocalDateTime endDateTime = startDateTime.plusMinutes(20);
                Match match = new Match(startDateTime, endDateTime, location);

                match.addTeam(firstTeam);
                match.addTeam(secondTeam);

                matchManager.persist(match);

                firstTeam.addMatch(match);
                secondTeam.addMatch(match);

                matchManager.merge(firstTeam);
                matchManager.merge(secondTeam);

                matchResultsService.add(new MatchResult(0, 0, match));;

                left++;
                right--;
                count++;
            }
            Team tempTeam = registeredTeams.get(registeredTeams.size() - 1);
            registeredTeams.set(registeredTeams.size() - 1, registeredTeams.get(registeredTeams.size() - 1 - i));
            registeredTeams.set(registeredTeams.size() - 1 - i, tempTeam);
        }
    }

    public List<Match> getAll() {
        TypedQuery<Match> query = matchManager.createNamedQuery(Match.GET_ALL_QUERY, Match.class);
        return query.getResultList();
    }

    public Match getById(Integer matchId) {
        Match match = matchManager.find(Match.class, matchId);

        if(match.isValid()) {
            return match;
        }
        else {
            throw new InvalidMatchException();
        }
    }
}
