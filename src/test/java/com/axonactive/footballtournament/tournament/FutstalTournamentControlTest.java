package com.axonactive.footballtournament.tournament;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import com.axonactive.footballtournament.member.Gender;
import com.axonactive.footballtournament.member.player.Player;
import com.axonactive.footballtournament.team.Team;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class FutstalTournamentControlTest {

    FutstalTournementControl futstalTournementControl;
    Team testedTeam;

    @BeforeEach
    void createInstance() {    
        futstalTournementControl = new FutstalTournementControl();
        testedTeam =  new Team("Axon Active", "AAVN");    
    }

    @DisplayName("when create instances")
    @Nested
    class WhenCreateInstances{
        @BeforeEach
        void pushPlayersToTeam() {
            testedTeam.addPlayer(new Player("John", "Doe", 21, Gender.MALE, "10"));
            testedTeam.addPlayer(new Player("Hero", "Ku", 22, Gender.MALE, "09"));
            testedTeam.addPlayer(new Player("Balt", "Gei", 23, Gender.UNKNOW, "69"));
            testedTeam.addPlayer(new Player("Hello", "World", 21, Gender.FEMALE, "01"));
            testedTeam.addPlayer(new Player("Jimmy", "Dan", 21, Gender.MALE, "11"));
            testedTeam.addPlayer(new Player("Joe", "Dim", 20, Gender.FEMALE, "12"));
            testedTeam.addPlayer(new Player("Love", "Hermes", 20, Gender.FEMALE, "20"));
        }

        @DisplayName("after push players")
        @Nested
        class AfterPushPlayers{

            @Test
            void isTeamMembersAtLeast7AndMaximum12() {        
                assertTrue(futstalTournementControl.isEnoughPlayer(testedTeam));
            }

            @Test
            void testRegisterTeamForTournamentFunction() {
                futstalTournementControl.registerForTournement(testedTeam);
                assertEquals(futstalTournementControl.getRegisteredTeams().size(), 1);
            }
        }
    }

}
