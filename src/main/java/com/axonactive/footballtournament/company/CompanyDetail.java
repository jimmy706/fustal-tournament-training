package com.axonactive.footballtournament.company;

import java.util.List;

import com.axonactive.footballtournament.member.player.Player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CompanyDetail {
    private String id;
    private String name;
    private int keyId;
    private List<Player> players;


}
