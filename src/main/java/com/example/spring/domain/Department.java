package com.example.spring.domain;

import com.example.spring.domain.templates.BaseEntity;
import jakarta.persistence.*;


@Entity
@Table(name = "department")
public class Department extends BaseEntity{

    @Column(name = "name")
    private String name;

    private String address;

    @ManyToOne
    @JoinColumn(name = "area_id", referencedColumnName = "id")
    private Area area;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
