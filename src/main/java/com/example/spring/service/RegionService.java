package com.example.spring.service;

import com.example.spring.domain.Region;
import com.example.spring.domain.request.ReqRegion;

import java.util.List;

public interface RegionService {
    public String createRegion(ReqRegion reqRegion);
    public String updateRegion(ReqRegion reqRegion);
    public List<Region> getAllRegions();

    public Region findRegionById(Long id);
}
