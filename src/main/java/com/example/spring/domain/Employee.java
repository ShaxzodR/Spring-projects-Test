package com.example.spring.domain;

import com.example.spring.domain.enumation.Gender;
import com.example.spring.domain.enumation.Position;
import com.example.spring.domain.templates.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "employee")
public class Employee extends BaseEntity{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "year_of_birth")
    private String yearOfBirth;

    @Column(name = "graduated_university")
    private String graduatedUniversity;

    @Column(name = "position")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

}
