package com.example.spring.domain;

import com.example.spring.domain.enumation.Position;
import com.example.spring.domain.enumation.Status;
import com.example.spring.domain.templates.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "task")
public class Task extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "deadline")
    private Date deadline;

    @ManyToOne()
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @OneToOne
    private Employee createdBy;

    @OneToOne
    private Employee updatedBy;


}
