package com.axonactive.footballtournament.member;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.axonactive.footballtournament.member.player.Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    Player player;

    @BeforeEach
    void createInstance() {
        player = new Player("John", "Doe", 21, Gender.MALE, "10");
    }

    @Test
    void testComparePlayerAndMember() {
        Member testedMember = new Member("John", "Doe", 21, Gender.MALE);
        assertEquals(player, testedMember);
    }

    @Test
    void testSetterFuntions() {
        player.setAge(22);
        player.setFirstName("Hello");
        player.setLastName("World");
        player.setPlayerNumber("20");

        assertEquals(player.getAge(), 22);
        assertEquals(player.getFirstName(), "Hello");
        assertEquals(player.getLastName(), "World");
        assertEquals(player.getPlayerNumber(), "20");
    }
}
