package com.axonactive.footballtournament.match;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.axonactive.footballtournament.member.Gender;
import com.axonactive.footballtournament.member.player.Player;
import com.axonactive.footballtournament.team.Team;
import com.axonactive.footballtournament.tournament.FutstalTournementControl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class MatchScheduleControlTest {
    List<Team> registeredTeams;
    Team team1;
    Team team2;
    Team team3;
    Team team4;
    Team team5;
    Team team6;

    @Test
    void createInstances() {
        registeredTeams = new ArrayList<>();
    }

    @Nested
    class AfterCreateInstances {
        @BeforeEach
        void pushPlayersToTeams() {
            team1 = new Team("Axon Active", "AAVN");
            team2 = new Team("MicroHard", "MH");
            team3 = new Team("Fruit", "FU");
            team4 = new Team("LifeInvader", "LI");
            team5 = new Team("Vin", "VI");
            team6 = new Team("Giigle", "GG");

            /**
             * Add players to team1
             */
            team1.addPlayer(new Player("John", "Doe", 21, Gender.MALE, "10"));
            team1.addPlayer(new Player("Hero", "Ku", 22, Gender.MALE, "09"));
            team1.addPlayer(new Player("Balt", "Gei", 23, Gender.UNKNOW, "69"));
            team1.addPlayer(new Player("Hello", "World", 21, Gender.FEMALE, "01"));
            team1.addPlayer(new Player("Jimmy", "Dan", 21, Gender.MALE, "11"));
            team1.addPlayer(new Player("Joe", "Dim", 20, Gender.FEMALE, "12"));
            team1.addPlayer(new Player("Love", "Hermes", 20, Gender.FEMALE, "20"));

            /**
             * Add players to team2
             */
            team2.addPlayer(new Player("Bill", "Gave", 69, Gender.MALE, "10"));
            team2.addPlayer(new Player("Stive", "Jov", 21, Gender.MALE, "01"));
            team2.addPlayer(new Player("Fairy", "Winx", 21, Gender.FEMALE, "69"));
            team2.addPlayer(new Player("Max", "Payne", 21, Gender.MALE, "12"));
            team2.addPlayer(new Player("Heru", "Dan", 21, Gender.MALE, "11"));
            team2.addPlayer(new Player("Tom", "Stark", 21, Gender.MALE, "09"));
            team2.addPlayer(new Player("Hello", "World", 21, Gender.MALE, "02"));

            /**
             * Add players to team3
             */
            team3.addPlayer(new Player("Balt", "Lki", 21, Gender.MALE, "10"));
            team3.addPlayer(new Player("Stive", "Jov", 21, Gender.MALE, "01"));
            team3.addPlayer(new Player("Max", "Dune", 21, Gender.MALE, "69"));
            team3.addPlayer(new Player("Max", "Payne", 21, Gender.FEMALE, "12"));
            team3.addPlayer(new Player("Heru", "Dan", 21, Gender.FEMALE, "11"));
            team3.addPlayer(new Player("Tom", "Stark", 21, Gender.MALE, "09"));
            team3.addPlayer(new Player("Hello", "World", 21, Gender.MALE, "02"));

            /**
             * Add players to team4
             */
            team4.addPlayer(new Player("John", "Doe", 21, Gender.MALE, "10"));
            team4.addPlayer(new Player("Hero", "Ku", 22, Gender.MALE, "09"));
            team4.addPlayer(new Player("Balt", "Gei", 23, Gender.UNKNOW, "69"));
            team4.addPlayer(new Player("Hello", "World", 21, Gender.FEMALE, "01"));
            team4.addPlayer(new Player("Jimmy", "Dan", 21, Gender.MALE, "11"));
            team4.addPlayer(new Player("Joe", "Dim", 20, Gender.FEMALE, "12"));
            team4.addPlayer(new Player("Love", "Hermes", 20, Gender.FEMALE, "20"));

            /**
             * Add players to team5
             */
            team5.addPlayer(new Player("John", "Doe", 21, Gender.MALE, "10"));
            team5.addPlayer(new Player("Hero", "Ku", 22, Gender.MALE, "09"));
            team5.addPlayer(new Player("Balt", "Gei", 23, Gender.UNKNOW, "69"));
            team5.addPlayer(new Player("Hello", "World", 21, Gender.FEMALE, "01"));
            team5.addPlayer(new Player("Jimmy", "Dan", 21, Gender.MALE, "11"));
            team5.addPlayer(new Player("Joe", "Dim", 20, Gender.FEMALE, "12"));
            team5.addPlayer(new Player("Love", "Hermes", 20, Gender.FEMALE, "20"));

            /**
             * Add players to team6
             */
            team6.addPlayer(new Player("John", "Doe", 21, Gender.MALE, "10"));
            team6.addPlayer(new Player("Hero", "Ku", 22, Gender.MALE, "09"));
            team6.addPlayer(new Player("Balt", "Gei", 23, Gender.UNKNOW, "69"));
            team6.addPlayer(new Player("Hello", "World", 21, Gender.FEMALE, "01"));
            team6.addPlayer(new Player("Jimmy", "Dan", 21, Gender.MALE, "11"));
            team6.addPlayer(new Player("Joe", "Dim", 20, Gender.FEMALE, "12"));
            team6.addPlayer(new Player("Love", "Hermes", 20, Gender.FEMALE, "20"));
        }

        @Nested
        class AfterAddPlayers {
            FutstalTournementControl tournementControl;
            MatchScheduleControl matchScheduleControl;
            @BeforeEach
            void registerTeamsForTournament() {
                tournementControl = new FutstalTournementControl();

                tournementControl.registerForTournement(team1);
                tournementControl.registerForTournement(team2);
                tournementControl.registerForTournement(team3);
                tournementControl.registerForTournement(team4);
                tournementControl.registerForTournement(team5);
                tournementControl.registerForTournement(team6);

                matchScheduleControl = new MatchScheduleControl(
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

            @Test
            void when_TeamMakeScore_MatchResultChanged() {
                List<Match> matches = matchScheduleControl.getMatches();

                MatchResultsControl matchResultsControl = new MatchResultsControl(matches);
                matchResultsControl.newScore(matches.get(0), ScoreTypes.FIRST_TEAM_SCORE);

                List<MatchResult> matchResults = matchResultsControl.getMatchResults();

                assertEquals(1, matchResults.get(0).getFirstTeamScore());

                assertEquals(Winner.FIRST_TEAM, matchResults.get(0).getWinner());;

                matchResultsControl.newScore(matches.get(0), ScoreTypes.SECOND_TEAM_SCORE);
                matchResultsControl.newScore(matches.get(0), ScoreTypes.SECOND_TEAM_SCORE);

                assertEquals(Winner.SECOND_TEAM, matchResults.get(0).getWinner());
            }

            @Test
            void when_2TeamScoresEqual_ExpectedDraw() {
                MatchResultsControl matchResultsControl = new MatchResultsControl(matchScheduleControl.getMatches());

                List<MatchResult> matchResults = matchResultsControl.getMatchResults();

                assertEquals(Winner.DRAW, matchResults.get(0).getWinner());
            }

            @Test
            void when_RequestTeamScore_GetMapOfTeamAndScore() {
                MatchResultsControl matchResultsControl = new MatchResultsControl(matchScheduleControl.getMatches());
                List<Match> matches = matchScheduleControl.getMatches();

                matchResultsControl.newScore(matches.get(0), ScoreTypes.FIRST_TEAM_SCORE);
                matchResultsControl.newScore(matches.get(0), ScoreTypes.SECOND_TEAM_SCORE);
                matchResultsControl.newScore(matches.get(0), ScoreTypes.FIRST_TEAM_SCORE);

                matchResultsControl.newScore(matches.get(2), ScoreTypes.FIRST_TEAM_SCORE);
                matchResultsControl.newScore(matches.get(2), ScoreTypes.SECOND_TEAM_SCORE);
                matchResultsControl.newScore(matches.get(2), ScoreTypes.SECOND_TEAM_SCORE);
                matchResultsControl.newScore(matches.get(2), ScoreTypes.SECOND_TEAM_SCORE);

                matchResultsControl.newScore(matches.get(3), ScoreTypes.FIRST_TEAM_SCORE);
                matchResultsControl.newScore(matches.get(3), ScoreTypes.FIRST_TEAM_SCORE);

                matchResultsControl.newScore(matches.get(4), ScoreTypes.SECOND_TEAM_SCORE);
                matchResultsControl.newScore(matches.get(4), ScoreTypes.FIRST_TEAM_SCORE);

                matchResultsControl.newScore(matches.get(5), ScoreTypes.FIRST_TEAM_SCORE);
                matchResultsControl.newScore(matches.get(5), ScoreTypes.FIRST_TEAM_SCORE);
                matchResultsControl.newScore(matches.get(5), ScoreTypes.SECOND_TEAM_SCORE);

                matchResultsControl.newScore(matches.get(6), ScoreTypes.SECOND_TEAM_SCORE);
                matchResultsControl.newScore(matches.get(6), ScoreTypes.SECOND_TEAM_SCORE);

                Map<String, Integer> teamScores = matchResultsControl.getTeamScores();
                assertTrue(teamScores instanceof Map);
                matchResultsControl.getSortedTeamScore(false);
            }
            
        }
    }
}
