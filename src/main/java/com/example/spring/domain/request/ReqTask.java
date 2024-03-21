package com.example.spring.domain.request;

import lombok.Data;

import java.util.Date;

@Data
public class ReqTask {
    private Long id;
    private String title;
    private String text;
    private Date deadline;
    private String status;
    private Long employee;
    private Long createdBy;
    private Long updateBy;
}

