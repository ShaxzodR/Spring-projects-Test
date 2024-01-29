package com.example.spring.domain;

import com.example.spring.domain.templates.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "company")
public class Company extends BaseEntity{

    @Column(name = "name")
    private String name;

    private String address;

    @ManyToOne
    @JoinColumn(name = "area_id", referencedColumnName = "id")
    private Area area;

}
