package com.example.spring.service;

import com.example.spring.domain.Area;
import com.example.spring.domain.request.ReqArea;

import java.util.List;
import java.util.Optional;

public interface AreaService {
    public String createArea(ReqArea reqArea);
    public String updateArea(ReqArea reqArea) ;

    public List<Area> getAllArea();

    public List<Area> getByDistrictId(Long regionId);

    public Area findAreaById(Long id);

}
