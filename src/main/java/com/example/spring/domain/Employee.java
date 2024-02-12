package com.example.spring.domain;

import com.example.spring.domain.enumation.Gender;
import com.example.spring.domain.enumation.Position;
import com.example.spring.domain.templates.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "employee")
public class Employee extends BaseEntity{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "year_of_birth")
    private String yearOfBirth;

    @Column(name = "graduated_university")
    private String graduatedUniversity;

    @Enumerated(EnumType.STRING)
    private Position position;

    @ManyToOne
    private Department department;

}
