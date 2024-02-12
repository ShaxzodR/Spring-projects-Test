package com.example.spring.domain.request;

import lombok.Data;

@Data
public class ReqRegion {
    private Long id;
    private String name;

    public ReqRegion(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
