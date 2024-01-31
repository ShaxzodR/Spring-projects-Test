package com.example.spring.service.impl;

import com.example.spring.domain.Region;
import com.example.spring.domain.request.ReqRegion;
import com.example.spring.repository.RegionRepoository;
import com.example.spring.service.RegionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionServiceImpl implements RegionService {

    private final RegionRepoository regionRep;

    public RegionServiceImpl(RegionRepoository regionRep) {
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

    public String updateRegion(ReqRegion reqRegion) {
        try {
            if (reqRegion.getId() != null) {
                if (regionRep.findById(reqRegion.getId()).isPresent()) {
                    Region currentRegion = regionRep.findById(reqRegion.getId()).get();
                    currentRegion.setName(reqRegion.getName());
                    regionRep.save(currentRegion);
                    return "Muvoffaqiyatli saqlandi!";
                } else {
                    return "Bunday tuman bazada topilmadi!";
                }
            } else {
                return "Viloyat tanlanmadi";
            }
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
