package com.uday.location.repository;

import com.uday.location.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    @Query("select l.type, count(l.code) from Location l group by type")
    List<Object[]> getTypeAndCountType();
}
