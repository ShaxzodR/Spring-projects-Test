package com.example.spring.service.impl;

import com.example.spring.domain.Area;
import com.example.spring.domain.request.ReqArea;
import com.example.spring.repository.AreaRepositry;
import com.example.spring.repository.DistrictRep;
import com.example.spring.service.AreaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaServiceImpl implements AreaService {
    public final AreaRepositry areaRepositry;
    public final DistrictRep districtRep;

    public AreaServiceImpl(AreaRepositry areaRep, DistrictRep districtRep) {
        this.areaRepositry = areaRep;
        this.districtRep = districtRep;
    }

    public String createArea(ReqArea reqArea) {
        try {
            Area area = new Area();
            area.setName(reqArea.getName());
            area.setDistrict(districtRep.findById(reqArea.getDistrict()).orElseThrow(()-> new EntityNotFoundException("Bunaqa tuman topilmadi")));
            areaRepositry.save(area);
            return "Muvoffaqiyatli saqlandi!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Xatolik";
        }
    }
    public String updateArea(ReqArea reqArea) {
        try {
            if (reqArea.getId()!= null){
                if (areaRepositry.findById(reqArea.getId()).isPresent()) {
                    Area currentArea = areaRepositry.findById(reqArea.getId()).get();
                    currentArea.setId(reqArea.getId());
                    currentArea.setName(reqArea.getName());
                    currentArea.setDistrict(districtRep.findById(reqArea.getDistrict()).orElseThrow(() -> new EntityNotFoundException("Bunaqa tuman topilmadi")));
                    areaRepositry.save(currentArea);
                    return "Muvoffaqiyatli uzgartirildi!";
                }else {
                    return "bunday ID li joy topilmadi";
                }
            } else {
               return "Joy tanlanmadi";
            }
        }catch (Exception e) {
            e.printStackTrace();
            return "Xatolik";
        }
    }

    public List<Area> getAllArea() {
        List<Area> areaList = areaRepositry.findAll();
        return areaList;
    }

    public List<Area> getByDistrictId(Long regionId) {
        List<Area> byRegionId = areaRepositry.getByDistrictId(regionId);
        return byRegionId;
    }

    public Area findAreaById(Long id) {
        Optional<Area> byId = areaRepositry.findById(id);
        if (byId.isPresent()) {
            Area area = byId.get();
            return area;
        } else {
            return new Area();
        }
    }
}
