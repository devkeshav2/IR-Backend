package com.indian.railway.repository;

import com.indian.railway.entity.TrainRoute;
import com.indian.railway.entity.TrainRouteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrainRouteRepository
        extends JpaRepository<TrainRoute, TrainRouteId> {

    // Get full route ordered by stop number
    List<TrainRoute> findByTrain_TrainIdOrderById_StopNumber(String trainId);

    // Get only active route
    @Query("""
        SELECT tr
        FROM TrainRoute tr
        WHERE tr.train.trainId = :trainId
          AND tr.active = true
        ORDER BY tr.id.stopNumber
    """)
    List<TrainRoute> findActiveRouteByTrain(@Param("trainId") String trainId);

    // Search trains between two stations
    @Query("""
        SELECT DISTINCT t1.train
        FROM TrainRoute t1
        JOIN TrainRoute t2
          ON t1.train.trainId = t2.train.trainId
        WHERE t1.station.id = :sourceStationId
          AND t2.station.id = :destinationStationId
          AND t1.id.stopNumber < t2.id.stopNumber
          AND t1.active = true
          AND t2.active = true
    """)
    List<?> findTrainsBetweenStations(
            @Param("sourceStationId") String sourceStationId,
            @Param("destinationStationId") String destinationStationId
    );
}
