package com.axonactive.footballtournament.match;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        }

        @Nested
        class AfterAddPlayers {
            FutstalTournementControl tournementControl;

            @BeforeEach
            void registerTeamsForTournament() {
                tournementControl = new FutstalTournementControl();

                tournementControl.registerForTournement(team1);
                tournementControl.registerForTournement(team2);
                tournementControl.registerForTournement(team3);
                tournementControl.registerForTournement(team4);
            }

            @Test
            void testGenerateSchedule() {

                MatchScheduleControl matchScheduleControl = new MatchScheduleControl(
                        tournementControl.getRegisteredTeams());

                matchScheduleControl.generateMatches("Viet Nam");

                List<Match> matches = matchScheduleControl.getMatches();
                assertEquals(matches.size(), 8);
                /**
                 * Just print match list
                 */
                // matches.stream().sorted((match1, match2) -> {
                //     return match1.getStartDateTime().compareTo(match2.getStartDateTime());
                // }).collect(Collectors.toList()).forEach(match -> System.out.println(match));
                matchScheduleControl.viewMatchSchedules();

            }
        }
    }
}
