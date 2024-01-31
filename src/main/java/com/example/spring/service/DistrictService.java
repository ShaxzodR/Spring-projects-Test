package com.example.spring.service;

import com.example.spring.domain.District;
import com.example.spring.domain.request.ReqDistrict;

import java.util.List;
import java.util.Optional;

public interface DistrictService {
    public String createDistrict(ReqDistrict reqDistrict);

    public String updateDistrict(ReqDistrict reqDistrict);

    public List<District> getAllDistricts();
    public List<District> findByRegionId(Long regionId);

    public District findDistrictById(Long id);

    public void delete(Long id);
}
