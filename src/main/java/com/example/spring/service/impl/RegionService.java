package com.example.spring.service.impl;

import com.example.spring.domain.District;
import com.example.spring.domain.Region;
import com.example.spring.domain.request.ReqDistrict;
import com.example.spring.domain.request.ReqRegion;
import com.example.spring.repository.RegionRep;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    private final RegionRep regionRep;

    public RegionService(RegionRep regionRep) {
        this.regionRep = regionRep;
    }

    public String createRegion(ReqRegion reqRegion) {
        try {
            Region region = new Region();
            region.setName(reqRegion.getName());
            regionRep.save(region);
            return "Muvoffaqiyatli saqlandi!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Xatolik";
        }
    }

    public List<Region> getAllRegions() {
        List<Region> all = regionRep.findAll();
        return all;
    }


    public Region findRegionById(Long id) {
        Optional<Region> byId = regionRep.findById(id);
        if (byId.isPresent()) {
            Region region = byId.get();
            return region;
        } else {
            return new Region();
        }
    }
}
