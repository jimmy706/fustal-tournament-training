package com.axonactive.footballtournament.match;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.axonactive.footballtournament.match.scoretype.ScoreTypes;
import com.axonactive.footballtournament.team.Team;

import lombok.Getter;

public class MatchResultsService{
    @Getter
    private List<MatchResult> matchResults;


    public MatchResultsService(List<Match> matches) {
        this.matchResults = new ArrayList<>();
        for(int i = 0; i < matches.size(); i++) {
            matchResults.add(new MatchResult(0, 0, matches.get(i)));
        }
    }

    public void newScore(Match scoredMatch, ScoreTypes scoreTypes) {
        for(MatchResult matchResult : matchResults) {
            if(scoredMatch.equals(matchResult.getMatch())){
                matchResult.score(scoreTypes);
                return;
            }
        }
    }
    
    // public Map<String, Integer> getTeamScores(){
    //     Map<String, Integer> response = new HashMap<>();

    //     matchResults.forEach(matchResult -> {
    //         Team team1 = matchResult.getMatch().getFirstTeam();
    //         Team team2 = matchResult.getMatch().getSecondTeam();

    //         String team1Company = team1.getCompany();
    //         String team2Company = team2.getCompany();

    //         int team1Score = matchResult.getFirstTeamScore();
    //         int team2Score = matchResult.getSecondTeamScore();

    //         if(response.containsKey(team1Company)) {
    //             response.put(team1Company, response.get(team1Company) + team1Score);
    //         }
    //         else {
    //             response.put(team1Company, team1Score);
    //         }

    //         if(response.containsKey(team2Company)) {
    //             response.put(team2Company, response.get(team2Company) + team2Score);
    //         }   
    //         else {
    //             response.put(team2Company, team2Score);
    //         }         
    //     });

    //     return response;
    // }
    
    // public void getSortedTeamScore(boolean ASC_score) {
    //     Map<String, Integer> response = getTeamScores();


    //     response.entrySet().stream()
    //         .sorted((entry1, entry2) -> {
    //             if(ASC_score) {
    //                 return entry1.getValue() - entry2.getValue();
    //             }
    //             else {
    //                 return entry2.getValue() - entry1.getValue();
    //             }
    //         })
    //         .forEach(entry -> {
    //             System.out.println(entry.getKey() + " - " + entry.getValue());
    //         });;
                            
    // }
}
