package com.example.spring.service.impl;

import com.example.spring.domain.District;
import com.example.spring.domain.request.ReqDistrict;
import com.example.spring.repository.DistrictRep;
import com.example.spring.repository.RegionRepoository;
import com.example.spring.service.DistrictService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictServiceImpl implements DistrictService {
    private final DistrictRep districtRep;
    private final RegionRepoository regionRepoository;

    public DistrictServiceImpl(DistrictRep districtRep, RegionRepoository regionRep) {
        this.districtRep = districtRep;
        this.regionRepoository = regionRep;
    }

    public String createDistrict(ReqDistrict reqDistrict) {
        try {
            District district = new District();
            district.setName(reqDistrict.getName());
            district.setRegion(regionRepoository.findById(reqDistrict.getRegionId()).orElseThrow(() -> new EntityNotFoundException(" bunday region Id topilmadi")));
            districtRep.save(district);
            return "Muvoffaqiyatli saqlandi!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Xatolik";
        }
    }

    public String updateDistrict(ReqDistrict reqDistrict) {
        try {
            if (reqDistrict.getId() != null) {
                if (districtRep.findById(reqDistrict.getId()).isPresent()) {
                    District currentDistrict = districtRep.findById(reqDistrict.getId()).get();
                    currentDistrict.setName(reqDistrict.getName());
                    currentDistrict.setRegion(regionRepoository.findById(reqDistrict.getRegionId()).orElseThrow(() -> new EntityNotFoundException(" bunday region Id topilmadi")));
                    districtRep.save(currentDistrict);
                    return "Muvoffaqiyatli uzgartirildi!";
                } else {
                    return "Bunday tuman bazada topilmadi!";
                }
            }else {
                return " Tuman tanlanmadi";
            }
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
