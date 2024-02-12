package com.example.spring.domain.request;

import lombok.Data;

@Data
public class ReqDepartment {
    private Long id;
    private String name;
    private String address;
    private Long areaId;

}
