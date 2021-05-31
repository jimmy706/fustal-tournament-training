package com.axonactive.footballtournament.company;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CompanyListItem {
    private int keyId;

    private String name;
    
    private String id;


}
