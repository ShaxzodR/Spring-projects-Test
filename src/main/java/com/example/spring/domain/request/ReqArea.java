package com.example.spring.domain.request;

public class ReqArea {
    private Long id;
    private String name;
    private long district;
    public ReqArea(Long id, String name, long district) {
        this.id = id;
        this.name = name;
        this.district = district;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDistrict() {
        return district;
    }

    public void setDistrict(long district) {
        this.district = district;
    }


}
