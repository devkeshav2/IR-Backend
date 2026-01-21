package com.indian.railway.repository;

import com.indian.railway.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {

    // Search by station code (exact)
    Station findByStationCode(String stationCode);


    Station findByStationId(String stationId);

    // Search by station name (like)
    List<Station> findByStationNameContainingIgnoreCase(String name);

    // Search by state
    List<Station> findByStateIgnoreCase(String state);

    // Optional: check if station exists by code
    boolean existsByStationCode(String stationCode);
}
