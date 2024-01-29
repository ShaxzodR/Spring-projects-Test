package com.example.spring.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

