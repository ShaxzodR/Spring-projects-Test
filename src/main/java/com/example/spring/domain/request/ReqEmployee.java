package com.example.spring.domain.request;

import lombok.Data;

@Data
public class ReqEmployee {
    private Long id;
    private String firstName;
    private String lastName;
    private int gender;
    private String position;
    private String workSchedule;
    private String yearOfBirth;
    private String graduatedUniversity;
    private Long companyId;
    private Long taskId;
}

