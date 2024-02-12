package com.example.spring.domain.request;

import lombok.Data;

@Data
public class ReqArea {
    private Long id;
    private String name;
    private long district;

    public ReqArea(Long id, String name, long district) {
        this.id = id;
        this.name = name;
        this.district = district;
    }

}
