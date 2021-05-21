package com.axonactive.footballtournament.match;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.axonactive.footballtournament.team.Team;

import lombok.Getter;

public class MatchScheduleControl implements MatchSchedules {

    @Getter
    private List<Match> matches;

    private int[] markedFightTeams;

    private List<Team> registeredTeams;

    public MatchScheduleControl(List<Team> registeredTeams) {
        this.registeredTeams = registeredTeams;
        this.markedFightTeams = new int[registeredTeams.size()];
        this.matches = new ArrayList<>();
        for (int index = 0; index < registeredTeams.size(); index++) {
            markedFightTeams[index] = 1;
        }
    }

    @Override
    public void generateMatches(String location) {
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
                Match match = new Match(firstTeam, secondTeam, startDateTime, endDateTime, location);

                matches.add(match);
                left++;
                right--;
                count++;
            }
            Team tempTeam = registeredTeams.get(registeredTeams.size() - 1);
            registeredTeams.set(registeredTeams.size() - 1, registeredTeams.get(registeredTeams.size() - 1 - i));
            registeredTeams.set(registeredTeams.size() - 1 - i, tempTeam);
        }

    }

    @Override
    public void viewMatchSchedules() {
        for (Match match : matches) {
            System.out.println("\n" + match + "\n");
        }
    }

}
