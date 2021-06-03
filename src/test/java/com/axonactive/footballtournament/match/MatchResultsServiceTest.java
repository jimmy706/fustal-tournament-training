package com.axonactive.footballtournament.match;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.axonactive.footballtournament.company.Company;
import com.axonactive.footballtournament.match.scoretype.ScoreTypes;
import com.axonactive.footballtournament.match.winner.Winner;
import com.axonactive.footballtournament.member.Gender;
import com.axonactive.footballtournament.member.Member;
import com.axonactive.footballtournament.member.player.Player;
import com.axonactive.footballtournament.team.Team;
import com.axonactive.footballtournament.tournament.FutstalTournementService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class MatchResultsServiceTest {
    MatchScheduleService matchScheduleControl;

    Company company1;
    Company company2;
    Company company3;
    Company company4;
    Company company5;
    Company company6;

    @BeforeEach
    void createInstances() {
        matchScheduleControl = new MatchScheduleService(new ArrayList<>());
    }

    @Nested
    class AfterCreateInstances {
        @BeforeEach
        void pushPlayersToTeams() {
            company1 = new Company("Axon Active", "AAVN");
            company2 = new Company("MicroHard", "MH");
            company3 = new Company("Fruit", "FU");
            company4 = new Company("LifeInvader", "LI");
            company5 = new Company("Vin", "VI");
            company6 = new Company("Giigle", "GG");

            /**
             * Add players to team1
             */
            company1.addPlayer(new Player(new Member("Jon", "Doe", 21, company1.getId(), Gender.MALE), "10"));
            company1.addPlayer(new Player(new Member("Jon", "Wick", 21, company1.getId(), Gender.MALE), "00"));
            company1.addPlayer(new Player(new Member("John", "Do", 21, company1.getId(), Gender.MALE), "9"));
            company1.addPlayer(new Player(new Member("Jim", "Doe", 21, company1.getId(), Gender.MALE), "01"));
            company1.addPlayer(new Player(new Member("Hello", "World", 21, company1.getId(), Gender.MALE), "08"));
            company1.addPlayer(new Player(new Member("Ron", "Doe", 21, company1.getId(), Gender.MALE), "70"));
            company1.addPlayer(new Player(new Member("Tim", "Doe", 21, company1.getId(), Gender.MALE), "69"));

            /**
             * Add players to team2
             */
            company2.addPlayer(new Player(new Member("Jon", "Doe", 21, company2.getId(), Gender.MALE), "10"));
            company2.addPlayer(new Player(new Member("Jon", "Wick", 21, company2.getId(), Gender.MALE), "00"));
            company2.addPlayer(new Player(new Member("John", "Do", 21, company2.getId(), Gender.MALE), "9"));
            company2.addPlayer(new Player(new Member("Jim", "Doe", 21, company2.getId(), Gender.MALE), "01"));
            company2.addPlayer(new Player(new Member("Hello", "World", 21, company2.getId(), Gender.MALE), "08"));
            company2.addPlayer(new Player(new Member("Ron", "Doe", 21, company2.getId(), Gender.MALE), "70"));
            company2.addPlayer(new Player(new Member("Tim", "Doe", 21, company2.getId(), Gender.MALE), "69"));

            /**
             * Add players to team3
             */
            company3.addPlayer(new Player(new Member("Jon", "Doe", 21, company3.getId(), Gender.MALE), "10"));
            company3.addPlayer(new Player(new Member("Jon", "Wick", 21, company3.getId(), Gender.MALE), "00"));
            company3.addPlayer(new Player(new Member("John", "Do", 21, company3.getId(), Gender.MALE), "9"));
            company3.addPlayer(new Player(new Member("Jim", "Doe", 21, company3.getId(), Gender.MALE), "01"));
            company3.addPlayer(new Player(new Member("Hello", "World", 21, company3.getId(), Gender.MALE), "08"));
            company3.addPlayer(new Player(new Member("Ron", "Doe", 21, company3.getId(), Gender.MALE), "70"));
            company3.addPlayer(new Player(new Member("Tim", "Doe", 21, company3.getId(), Gender.MALE), "69"));

            /**
             * Add players to team4
             */
            company4.addPlayer(new Player(new Member("Jon", "Doe", 21, company4.getId(), Gender.MALE), "10"));
            company4.addPlayer(new Player(new Member("Jon", "Wick", 21, company4.getId(), Gender.MALE), "00"));
            company4.addPlayer(new Player(new Member("John", "Do", 21, company4.getId(), Gender.MALE), "9"));
            company4.addPlayer(new Player(new Member("Jim", "Doe", 21, company4.getId(), Gender.MALE), "01"));
            company4.addPlayer(new Player(new Member("Hello", "World", 21, company4.getId(), Gender.MALE), "08"));
            company4.addPlayer(new Player(new Member("Ron", "Doe", 21, company4.getId(), Gender.MALE), "70"));
            company4.addPlayer(new Player(new Member("Tim", "Doe", 21, company4.getId(), Gender.MALE), "69"));

            /**
             * Add players to team5
             */
            company5.addPlayer(new Player(new Member("Jon", "Doe", 21, company5.getId(), Gender.MALE), "10"));
            company5.addPlayer(new Player(new Member("Jon", "Wick", 21, company5.getId(), Gender.MALE), "00"));
            company5.addPlayer(new Player(new Member("John", "Do", 21, company5.getId(), Gender.MALE), "9"));
            company5.addPlayer(new Player(new Member("Jim", "Doe", 21, company5.getId(), Gender.MALE), "01"));
            company5.addPlayer(new Player(new Member("Hello", "World", 21, company5.getId(), Gender.MALE), "08"));
            company5.addPlayer(new Player(new Member("Ron", "Doe", 21, company5.getId(), Gender.MALE), "70"));
            company5.addPlayer(new Player(new Member("Tim", "Doe", 21, company5.getId(), Gender.MALE), "69"));

            /**
             * Add players to team6
             */
            company6.addPlayer(new Player(new Member("Jon", "Doe", 21, company6.getId(), Gender.MALE), "10"));
            company6.addPlayer(new Player(new Member("Jon", "Wick", 21, company6.getId(), Gender.MALE), "00"));
            company6.addPlayer(new Player(new Member("John", "Do", 21, company6.getId(), Gender.MALE), "9"));
            company6.addPlayer(new Player(new Member("Jim", "Doe", 21, company6.getId(), Gender.MALE), "01"));
            company6.addPlayer(new Player(new Member("Hello", "World", 21, company6.getId(), Gender.MALE), "08"));
            company6.addPlayer(new Player(new Member("Ron", "Doe", 21, company6.getId(), Gender.MALE), "70"));
            company6.addPlayer(new Player(new Member("Tim", "Doe", 21, company6.getId(), Gender.MALE), "69"));
        }

        @Nested
        class AfterAddPlayers {
            FutstalTournementService tournementControl;
            @BeforeEach
            void registerTeamsForTournament() {
                tournementControl = new FutstalTournementService();

                tournementControl.registerForTournement(company1.getTeam());
                tournementControl.registerForTournement(company2.getTeam());
                tournementControl.registerForTournement(company3.getTeam());
                tournementControl.registerForTournement(company4.getTeam());
                tournementControl.registerForTournement(company5.getTeam());
                tournementControl.registerForTournement(company6.getTeam());

                matchScheduleControl = new MatchScheduleService(
                        tournementControl.getRegisteredTeams());

                matchScheduleControl.generateMatches("Viet Nam");
            }

            @Test
            void testGenerateSchedule() {                

                List<Match> matches = matchScheduleControl.getMatches();
                List<Team> registeredTeams = tournementControl.getRegisteredTeams();

                /**
                 * Expect matches size = (n - 1) * (int)(n / 2)
                 */
                assertEquals(matches.size(),  (registeredTeams.size() - 1) * (int)(registeredTeams.size() / 2) );
                matchScheduleControl.viewMatchSchedules();

            }

            // @Test
            // void when_TeamMakeScore_MatchResultChanged() {
            //     List<Match> matches = matchScheduleControl.getMatches();

            //     MatchResultsService matchResultsControl = new MatchResultsService(matches);
            //     matchResultsControl.newScore(matches.get(0), ScoreTypes.FIRST_TEAM_SCORE);

            //     List<MatchResult> matchResults = matchResultsControl.getMatchResults();

            //     assertEquals(1, matchResults.get(0).getFirstTeamScore());

            //     assertEquals(Winner.FIRST_TEAM, matchResults.get(0).getWinner());;

            //     matchResultsControl.newScore(matches.get(0), ScoreTypes.SECOND_TEAM_SCORE);
            //     matchResultsControl.newScore(matches.get(0), ScoreTypes.SECOND_TEAM_SCORE);

            //     assertEquals(Winner.SECOND_TEAM, matchResults.get(0).getWinner());
            // }

            // @Test
            // void when_2TeamScoresEqual_ExpectedDraw() {
            //     MatchResultsService matchResultsControl = new MatchResultsService(matchScheduleControl.getMatches());

            //     List<MatchResult> matchResults = matchResultsControl.getMatchResults();

            //     assertEquals(Winner.DRAW, matchResults.get(0).getWinner());
            // }

            // @Test
            // void when_RequestTeamScore_GetMapOfTeamAndScore() {
            //     MatchResultsService matchResultsControl = new MatchResultsService(matchScheduleControl.getMatches());
            //     List<Match> matches = matchScheduleControl.getMatches();

            //     matchResultsControl.newScore(matches.get(0), ScoreTypes.FIRST_TEAM_SCORE);
            //     matchResultsControl.newScore(matches.get(0), ScoreTypes.SECOND_TEAM_SCORE);
            //     matchResultsControl.newScore(matches.get(0), ScoreTypes.FIRST_TEAM_SCORE);

            //     matchResultsControl.newScore(matches.get(2), ScoreTypes.FIRST_TEAM_SCORE);
            //     matchResultsControl.newScore(matches.get(2), ScoreTypes.SECOND_TEAM_SCORE);
            //     matchResultsControl.newScore(matches.get(2), ScoreTypes.SECOND_TEAM_SCORE);
            //     matchResultsControl.newScore(matches.get(2), ScoreTypes.SECOND_TEAM_SCORE);

            //     matchResultsControl.newScore(matches.get(3), ScoreTypes.FIRST_TEAM_SCORE);
            //     matchResultsControl.newScore(matches.get(3), ScoreTypes.FIRST_TEAM_SCORE);

            //     matchResultsControl.newScore(matches.get(4), ScoreTypes.SECOND_TEAM_SCORE);
            //     matchResultsControl.newScore(matches.get(4), ScoreTypes.FIRST_TEAM_SCORE);

            //     matchResultsControl.newScore(matches.get(5), ScoreTypes.FIRST_TEAM_SCORE);
            //     matchResultsControl.newScore(matches.get(5), ScoreTypes.FIRST_TEAM_SCORE);
            //     matchResultsControl.newScore(matches.get(5), ScoreTypes.SECOND_TEAM_SCORE);

            //     matchResultsControl.newScore(matches.get(6), ScoreTypes.SECOND_TEAM_SCORE);
            //     matchResultsControl.newScore(matches.get(6), ScoreTypes.SECOND_TEAM_SCORE);

            //     Map<String, Integer> teamScores = matchResultsControl.getTeamScores();
            //     assertTrue(teamScores instanceof Map);
            //     matchResultsControl.getSortedTeamScore(false);
            // }
            
        }
    }
}
