package com.indian.railway.controller;

import com.indian.railway.common.GenericResponse;
import com.indian.railway.entity.Train;
import com.indian.railway.service.TrainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/trains")
@RequiredArgsConstructor
public class TrainController {

    private final TrainService trainService;

    @PostMapping
    public ResponseEntity<GenericResponse<Train>> create(@RequestBody Train train) {
        log.info("API: Create train");
        return ResponseEntity.status(201).body(trainService.createTrain(train));
    }

    @PutMapping("/{trainId}")
    public ResponseEntity<GenericResponse<Train>> update(@PathVariable String trainId, @RequestBody Train train) {
        log.info("API: Update train {}", trainId);
        return ResponseEntity.ok(trainService.updateTrain(trainId, train));
    }

    @GetMapping("/{trainId}")
    public ResponseEntity<GenericResponse<Train>> getById(@PathVariable String trainId) {
        log.info("API: Get train by id {}", trainId);
        return ResponseEntity.ok(trainService.getTrainById(trainId));
    }

    @GetMapping("/number/{trainNumber}")
    public ResponseEntity<GenericResponse<Train>> getByNumber(@PathVariable String trainNumber) {
        log.info("API: Get train by number {}", trainNumber);
        return ResponseEntity.ok(trainService.getTrainByNumber(trainNumber));
    }

    @GetMapping
    public ResponseEntity<GenericResponse<List<Train>>> getAll() {
        log.info("API: Get all trains");
        return ResponseEntity.ok(trainService.getAllTrains());
    }

    @GetMapping("/active")
    public ResponseEntity<GenericResponse<List<Train>>> getActive() {
        log.info("API: Get active trains");
        return ResponseEntity.ok(trainService.getActiveTrains());
    }

    @GetMapping("/search")
    public ResponseEntity<GenericResponse<List<Train>>> search(
            @RequestParam String source,
            @RequestParam String destination) {
        log.info("API: Search trains from {} to {}", source, destination);
        return ResponseEntity.ok(trainService.searchTrains(source, destination));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<GenericResponse<List<Train>>> byCategory(@PathVariable String category) {
        log.info("API: Get trains by category {}", category);
        return ResponseEntity.ok(trainService.getTrainsByCategory(category));
    }

    @PatchMapping("/{trainId}/deactivate")
    public ResponseEntity<GenericResponse<Void>> deactivate(@PathVariable String trainId) {
        log.info("API: Deactivate train {}", trainId);
        return ResponseEntity.ok(trainService.deactivateTrain(trainId));
    }

    @DeleteMapping("/{trainId}")
    public ResponseEntity<GenericResponse<Void>> delete(@PathVariable String trainId) {
        log.info("API: Delete train {}", trainId);
        return ResponseEntity.ok(trainService.deleteTrain(trainId));
    }
}

