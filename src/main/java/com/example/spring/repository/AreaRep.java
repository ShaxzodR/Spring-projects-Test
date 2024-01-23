package com.example.spring.repository;

import com.example.spring.domain.Area;
import com.example.spring.domain.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRep extends JpaRepository<Area, Long> {

    //    @Query(value = "select * from area left join public.district d on d.id = area.district_id\n" +
//            "left join public.region r on d.region_id = r.id",nativeQuery = true)
//    List<Area> leftJoin();
    @Query(value = "SELECT * FROM area a WHERE a.district_id = :districtId", nativeQuery = true)
    List<Area> getByDistrictId(@Param("districtId") Long districtId);


}
