package com.axonactive.footballtournament.team;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.Arrays;
import java.util.List;

import com.axonactive.footballtournament.member.Gender;
import com.axonactive.footballtournament.member.Member;
import com.axonactive.footballtournament.member.player.Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {
    Team team;

    @BeforeEach
    void createInstance() {
        team = new Team("Axon Active", "AAVN");        
    }

    @Test
    void shouldTeamPlayersNotNull() {
        assertNotNull(team.getPlayers());
    }

    @Test
    void testAddTeamPlayersAsExpected() {
        Player newPlayer = new Player("Stive", "Jove", 34, Gender.MALE, "09");
        List<Player> expectedPlayers = Arrays.asList(newPlayer);
        team.addPlayer(newPlayer);

        assertEquals(team.getPlayers(), expectedPlayers);
    }

    @Test
    void testTeamConstructorWithList() {
        Player newPlayer = new Player(new Member("John", "Doe", 21, Gender.MALE), "13");
        Team testedTeam = new Team("Axon Active", "AAVN", Arrays.asList(newPlayer));

        team.addPlayer(newPlayer);

        assertEquals(testedTeam, team);
        assertEquals(testedTeam.getPlayers().size(), 1);
    }
}
