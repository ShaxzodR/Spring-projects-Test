package com.example.spring.service.impl;

import com.example.spring.domain.District;
import com.example.spring.domain.Region;
import com.example.spring.domain.request.ReqDistrict;
import com.example.spring.repository.DistrictRep;
import com.example.spring.repository.RegionRep;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictService {
    private final DistrictRep districtRep;
    private final RegionRep regionRep;

    public DistrictService(DistrictRep districtRep, RegionRep regionRep) {
        this.districtRep = districtRep;
        this.regionRep = regionRep;
    }

    public String createDistrict(ReqDistrict reqDistrict) {
        try {
            District district = new District();
            district.setName(reqDistrict.getName());
            district.setRegion(regionRep.getReferenceById(reqDistrict.getRegionId()));
            districtRep.save(district);
            return "Muvoffaqiyatli saqlandi!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Xatolik";
        }
    }

    public String updateDistrict(ReqDistrict reqDistrict) {
        try {
            District district = new District();
            district.setId(reqDistrict.getId());
            district.setName(reqDistrict.getName());
            district.setRegion(regionRep.getReferenceById(reqDistrict.getRegionId()));
            districtRep.save(district);
            return "Muvoffaqiyatli uzgartirildi!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Xatolik";
        }
    }

    public List<District> getAllDistricts() {
        return districtRep.findAll();
    }

    public List<District> findByRegionId(Long regionId) {
        return districtRep.getByRegionId(regionId);
    }

    public District findDistrictById(Long id) {
        Optional<District> optionalDistrict = districtRep.findById(id);
        if (optionalDistrict.isPresent()) {
            return optionalDistrict.get();
        } else {
            return new District();
        }
    }

    public void delete(Long id) {
        District district = districtRep.getReferenceById(id);
        districtRep.delete(district);
    }


}
