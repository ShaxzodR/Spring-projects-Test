package com.example.spring.web.rest;

import com.example.spring.domain.District;
import com.example.spring.domain.request.ReqDistrict;
import com.example.spring.service.DistrictService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/districts")
public class DistrictResource {
    private final DistrictService districtService;

    public DistrictResource(DistrictService districtService) {
        this.districtService = districtService;
    }


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ReqDistrict district) {
        String response = districtService.createDistrict(district);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody ReqDistrict district) {
        String response = districtService.updateDistrict(district);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<District> districts = districtService.getAllDistricts();
        return ResponseEntity.ok(districts);
    }

    @GetMapping("/by-region-id/{id}")
    public ResponseEntity<?> findAllByRegionId(@PathVariable Long id) {
        List<District> region = districtService.findByRegionId(id);
        return ResponseEntity.ok(region);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        District district = districtService.findDistrictById(id);
        return ResponseEntity.ok(district);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        districtService.delete(id);
        return ResponseEntity.ok("O'chirildi");
    }

}

