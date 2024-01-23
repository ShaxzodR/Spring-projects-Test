package com.example.spring.repository;

import com.example.spring.domain.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRep extends JpaRepository<District, Long> {

//    @Query("SELECT d FROM District d LEFT JOIN FETCH d.region")
//    List<District> findAllWithRegions(Long id);
//    @Query("SELECT d FROM District d LEFT JOIN FETCH d.region")
//    List<District> findAllWithRegion();
//
//    Optional<District> findById(Long id);
    List<District> findAllByRegionId(Long region_id);


    @Query(value = "select * from District t where t.region_id=:regionId", nativeQuery = true)
    List<District> getByRegionId(Long regionId);




}
