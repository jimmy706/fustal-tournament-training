package com.axonactive.footballtournament.match;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class Match {

    @Column(name = "match_id")
    @Id
    @GeneratedValue
    private String matchId;

    @Column(name = "start_datetime", columnDefinition = "TIMESTAMP")
    LocalDateTime startDateTime;

    @Column(name = "end_datetime", columnDefinition = "TIMESTAMP")
    LocalDateTime endDateTime;

    @Column
    String location;

    public Match( LocalDateTime startDateTime, LocalDateTime endDateTime, String location ){
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.location = location;
    }


    
}
