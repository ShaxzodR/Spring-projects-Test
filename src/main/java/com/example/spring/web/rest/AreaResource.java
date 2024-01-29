package com.example.spring.web.rest;

import com.example.spring.domain.Area;
import com.example.spring.domain.request.ReqArea;
import com.example.spring.service.impl.AreaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/area")
public class AreaResource {
    private final AreaService areaService;

    public AreaResource(AreaService areaService) {
        this.areaService = areaService;
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ReqArea reqArea){
        String response = areaService.createArea(reqArea);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody ReqArea reqArea){
        String response = areaService.updateArea(reqArea);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        List<Area> areaList = areaService.getAllArea();
        return ResponseEntity.ok(areaList);
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Area areaById = areaService.findAreaById(id);
        return ResponseEntity.ok(areaById);
    }
    @GetMapping("/by-region-id/{id}")
    public ResponseEntity<?> findAllByRegionId(@PathVariable Long id) {
        List<Area> byRegionId = areaService.getByDistrictId(id);
        return ResponseEntity.ok(byRegionId);
    }

}
