package com.axonactive.footballtournament.match;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatchResultsControl implements MatchResults{

    private List<MatchResult> matchResults;

    private List<Match> matches;

    public MatchResultsControl(List<Match> matches) {
        this.matches = matches;
        this.matchResults = new ArrayList<>();
        for(int i = 0; i < matches.size(); i++) {
            matchResults.add(new MatchResult(0, 0, matches.get(i).getMatchId()));
        }
    }


    @Override
    public void viewAllResults() {
        System.out.println(Arrays.toString(matchResults.toArray()));
    }

    @Override
    public void newScore(Match scoredMatch, ScoreTypes scoreTypes) {
        for(MatchResult matchResult : matchResults) {
            if(scoredMatch.getMatchId().equals(matchResult.getMatch())){
                matchResult.score(scoreTypes);
                return;
            }
        }
    }
    
}
