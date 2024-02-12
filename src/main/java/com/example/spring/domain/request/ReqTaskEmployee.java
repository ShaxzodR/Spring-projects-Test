package com.example.spring.domain.request;

import lombok.Data;

@Data
public class ReqTaskEmployee {
    private Long id;
    private Long taskId;
    private long employeeId;
}
