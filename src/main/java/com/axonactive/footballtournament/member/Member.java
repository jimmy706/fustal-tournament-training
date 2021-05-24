package com.axonactive.footballtournament.member;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.axonactive.footballtournament.company.Company;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "members")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString(exclude = {"age", "gender"})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Member {    
    @Column
    @Id
    private int id;

    @Column
    private String firstName;

    @Column
    String lastName;

    @Column
    int age;

    @Column
    private String socialInsuranceId;    

    @Convert(converter = GenderPersistenceConverter.class)
    private Gender gender;

    public Member(String firstName, String lastName, int age, String socialInsuranceId, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.socialInsuranceId = socialInsuranceId;
        this.gender = gender;
    }

    public Member(String firstName, String lastName, int age, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    public boolean isValid() {
        return Objects.nonNull(getFullName()) && age > 18 && age < 60 && Objects.nonNull(gender);
    }
    

}
