package com.axonactive.footballtournament.tournament;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


import com.axonactive.footballtournament.member.Gender;
import com.axonactive.footballtournament.member.player.Player;
import com.axonactive.footballtournament.team.Team;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class FutstalTournamentServiceTest {

    FutstalTournementService futstalTournementControl;
    Team testedTeam;

    @BeforeEach
    void createInstance() {    
        futstalTournementControl = new FutstalTournementService();
        testedTeam =  new Team("Axon Active", "AAVN");    
    }

    @DisplayName("when create instances")
    @Nested
    class WhenCreateInstances{
        @BeforeEach
        void pushPlayersToTeam() {
            testedTeam.addPlayer(new Player("John", "Doe", 21, "AAVN", Gender.MALE, "10"));
            testedTeam.addPlayer(new Player("Hero", "Ku", 22, "AAVN", Gender.MALE, "09"));
            testedTeam.addPlayer(new Player("Balt", "Gei", 23, "AAVN", Gender.UNKNOW, "69"));
            testedTeam.addPlayer(new Player("Hello", "World", 21, "AAVN", Gender.FEMALE, "01"));
            testedTeam.addPlayer(new Player("Jimmy", "Dan", 21, "AAVN", Gender.MALE, "11"));
            testedTeam.addPlayer(new Player("Joe", "Dim", 20, "AAVN", Gender.FEMALE, "12"));
            testedTeam.addPlayer(new Player("Love", "Hermes", 20, "AAVN", Gender.FEMALE, "20"));
        }

        @DisplayName("after push players")
        @Nested
        class AfterPushPlayers{

            @Test
            void when_TeamMemberBetween7And12_ReturnTrue() {        
                assertTrue(futstalTournementControl.isEnoughPlayer(testedTeam));
            }

            @Test
            void when_RegisteredForTournament_RegisteredTeamSizeIncrease() {
                futstalTournementControl.registerForTournement(testedTeam);
                assertEquals(futstalTournementControl.getRegisteredTeams().size(), 1);
            }

            @Test
            void when_FailedToRegistered_ThrowIllegalArgumentException() {
                Team teamWithEmptyPlayer = new Team("Vim", "VI");
                assertThrows(IllegalArgumentException.class, ()-> {
                    futstalTournementControl.registerForTournement(teamWithEmptyPlayer);
                });
            }
        }
    }

}
