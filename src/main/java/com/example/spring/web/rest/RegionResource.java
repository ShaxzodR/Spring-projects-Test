package com.example.spring.web.rest;

import com.example.spring.domain.Region;
import com.example.spring.domain.request.ReqRegion;
import com.example.spring.service.RegionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/region")
public class RegionResource {

    private final RegionService regionService;

    public RegionResource(RegionService regionService) {
        this.regionService = regionService;
    }
    @PostMapping("/create")
    public ResponseEntity create(@RequestBody ReqRegion reqRegion){
        String response = regionService.createRegion(reqRegion);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        List<Region> regions=regionService.getAllRegions();
        return ResponseEntity.ok(regions);
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Region regionById = regionService.findRegionById(id);
        return ResponseEntity.ok(regionById);
    }
}
