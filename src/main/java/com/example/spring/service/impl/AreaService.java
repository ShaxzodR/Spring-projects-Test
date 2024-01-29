package com.example.spring.service.impl;

import com.example.spring.domain.Area;
import com.example.spring.domain.request.ReqArea;
import com.example.spring.repository.AreaRep;
import com.example.spring.repository.DistrictRep;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaService {
    public final AreaRep areaRep;
    public final DistrictRep districtRep;

    public AreaService(AreaRep areaRep, DistrictRep districtRep) {
        this.areaRep = areaRep;
        this.districtRep = districtRep;
    }

    public String createArea(ReqArea reqArea) {
        try {
            Area area = new Area();
            area.setId(reqArea.getId());
            area.setName(reqArea.getName());
            area.setDistrict(districtRep.getReferenceById(reqArea.getDistrict()));
            areaRep.save(area);
            return "Muvoffaqiyatli saqlandi!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Xatolik";
        }
    }
    public String updateArea(ReqArea reqArea) {
        try {
            Area area = new Area();
            area.setId(reqArea.getId());
            area.setName(reqArea.getName());
            area.setDistrict(districtRep.getReferenceById(reqArea.getDistrict()));
            areaRep.save(area);
            return "Muvoffaqiyatli uzgartirildi!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Xatolik";
        }
    }

    public List<Area> getAllArea() {
        List<Area> areaList = areaRep.findAll();
        return areaList;
    }

    public List<Area> getByDistrictId(Long regionId) {
        List<Area> byRegionId = areaRep.getByDistrictId(regionId);
        return byRegionId;
    }

    public Area findAreaById(Long id) {
        Optional<Area> byId = areaRep.findById(id);
        if (byId.isPresent()) {
            Area area = byId.get();
            return area;
        } else {
            return new Area();
        }
    }
}
