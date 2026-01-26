package com.indian.railway.controller;

import com.indian.railway.entity.TrainRoute;
import com.indian.railway.service.TrainRouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/train-route")
@RequiredArgsConstructor
public class TrainRouteController {

    private final TrainRouteService trainRouteService;

    /* ===============================
       ADMIN APIs
       =============================== */

    @PostMapping
    public ResponseEntity<TrainRoute> addTrainRoute(
            @RequestBody TrainRoute trainRoute
    ) {
        return ResponseEntity.ok(
                trainRouteService.addTrainRoute(trainRoute)
        );
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<TrainRoute>> addTrainRouteBulk(
            @RequestBody List<TrainRoute> routes
    ) {
        return ResponseEntity.ok(
                trainRouteService.addTrainRouteList(routes)
        );
    }

    @DeleteMapping("/train/{trainId}")
    public ResponseEntity<String> deactivateTrainRoute(
            @PathVariable String trainId
    ) {
        trainRouteService.deactivateRoute(trainId);
        return ResponseEntity.ok("Train route deactivated successfully");
    }

    /* ===============================
       USER APIs
       =============================== */

    @GetMapping("/train/{trainId}")
    public ResponseEntity<List<TrainRoute>> getRouteByTrain(
            @PathVariable String trainId
    ) {
        return ResponseEntity.ok(
                trainRouteService.getRouteByTrainId(trainId)
        );
    }

    @GetMapping("/search")
    public ResponseEntity<List<?>> searchTrains(
            @RequestParam String sourceStationId,
            @RequestParam String destinationStationId
    ) {
        return ResponseEntity.ok(
                trainRouteService.searchTrainsBetweenStations(
                        sourceStationId,
                        destinationStationId
                )
        );
    }
}
