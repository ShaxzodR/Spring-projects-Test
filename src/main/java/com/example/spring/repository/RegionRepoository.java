package com.example.spring.repository;

import com.example.spring.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepoository extends JpaRepository<Region, Long> {

//    @Query(value = "select * from region left join public.district d on region.id = d.region_id", nativeQuery = true)
//    List<Region> joinRegion();

//    List<District> getRegionId(Long )
}
