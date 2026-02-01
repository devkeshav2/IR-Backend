package com.indian.railway.controller;

import com.indian.railway.common.GenericResponse;
import com.indian.railway.dto.DropDown;
import com.indian.railway.entity.Station;
import com.indian.railway.service.StationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.indian.railway.common.APIConstants.*;
import static com.indian.railway.common.IRResponseConstants.*;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping(STATION_BASE_URL)
@PreAuthorize("hasRole('ADMIN')")
public class StationController {

   private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @PostMapping
    public ResponseEntity<GenericResponse<Station>> createStation(@RequestBody Station station) {
        log.info("Create station request: {}", station);
        Station saved = stationService.saveStation(station);

        GenericResponse<Station> response = new GenericResponse<>();
        response.setMessage(STATION_CREATED_SUCCESSFULLY);
        response.setResult(saved);
        response.setCount(1);
        response.setStatus(HttpStatus.CREATED.value());

        log.info("Station created: {}", saved.getStationId());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{stationId}")
    public ResponseEntity<GenericResponse<Station>> updateStation(@PathVariable String stationId,
                                                                  @RequestBody Station station) {
        log.info("Update station request for ID: {}", stationId);
        station.setStationId(stationId);
        Station updated = stationService.updateStation(station);

        GenericResponse<Station> response = new GenericResponse<>();
        response.setMessage(STATION_UPDATED_SUCCESSFULLY);
        response.setResult(updated);
        response.setCount(1);
        response.setStatus(HttpStatus.OK.value());

        log.info("Station updated: {}", stationId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{stationId}")
    public ResponseEntity<GenericResponse<Object>> deleteStation(@PathVariable String stationId) {
        log.info("Delete station request for ID: {}", stationId);
        stationService.deleteStation(stationId);

        GenericResponse<Object> response = new GenericResponse<>();
        response.setMessage(STATION_DELETED_SUCCESSFULLY);
        response.setResult(null);
        response.setCount(0);
        response.setStatus(HttpStatus.OK.value());

        log.info("Station deleted: {}", stationId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{stationId}")
    public ResponseEntity<GenericResponse<Station>> getStationById(@PathVariable String stationId) {
        log.info("Get station by ID request: {}", stationId);
        Station station = stationService.getStationById(stationId);

        GenericResponse<Station> response = new GenericResponse<>();
        if (station != null) {
            response.setMessage(STATION_RETRIEVED_SUCCESSFULLY);
            response.setResult(station);
            response.setCount(1);
            response.setStatus(HttpStatus.OK.value());
            log.info("Station found: {}", stationId);
        } else {
            response.setMessage(STATION_NOT_FOUND);
            response.setResult(null);
            response.setCount(0);
            response.setStatus(HttpStatus.NOT_FOUND.value());
            log.warn("Station not found: {}", stationId);
        }

        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @GetMapping
    public ResponseEntity<GenericResponse<List<Station>>> getAllStations() {
        log.info("Get all stations request");
        List<Station> stations = stationService.getAllStations();

        GenericResponse<List<Station>> response = new GenericResponse<>();
        response.setMessage(STATIONS_FETCHED_SUCCESSFULLY);
        response.setResult(stations);
        response.setCount(stations.size());
        response.setStatus(HttpStatus.OK.value());

        log.info("Total stations: {}", stations.size());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search/name")
    public ResponseEntity<GenericResponse<List<Station>>> searchByName(@RequestParam String name) {
        log.info("Search stations by name: {}", name);
        List<Station> stations = stationService.searchStationsByName(name);

        GenericResponse<List<Station>> response = new GenericResponse<>();
        response.setMessage("Stations search by name completed");
        response.setResult(stations);
        response.setCount(stations.size());
        response.setStatus(HttpStatus.OK.value());

        log.info("Search by name found: {}", stations.size());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search/state")
    public ResponseEntity<GenericResponse<List<Station>>> searchByState(@RequestParam String state) {
        log.info("Search stations by state: {}", state);
        List<Station> stations = stationService.searchStationsByState(state);

        GenericResponse<List<Station>> response = new GenericResponse<>();
        response.setMessage("Stations search by state completed");
        response.setResult(stations);
        response.setCount(stations.size());
        response.setStatus(HttpStatus.OK.value());

        log.info("Search by state found: {}", stations.size());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search/code")
    public ResponseEntity<GenericResponse<Station>> searchByCode(@RequestParam String code) {
        log.info("Search station by code: {}", code);
        Station station = stationService.getAllStations()
                .stream()
                .filter(s -> s.getStationCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);

        GenericResponse<Station> response = new GenericResponse<>();
        if (station != null) {
            response.setMessage("Station found by code");
            response.setResult(station);
            response.setCount(1);
            response.setStatus(HttpStatus.OK.value());
            log.info("Station found with code: {}", code);
        } else {
            response.setMessage("Station not found with code");
            response.setResult(null);
            response.setCount(0);
            response.setStatus(HttpStatus.NOT_FOUND.value());
            log.warn("Station not found with code: {}", code);
        }

        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @GetMapping("/search/stations")
    public ResponseEntity<GenericResponse<List<DropDown>>> getAllStationsListOnSearch(@RequestParam String stationCodeOrName) {
        log.info("Get all stations in dropdown for param : {} ",stationCodeOrName);
        List<DropDown> stations = stationService.getAllStationsInDropDown(stationCodeOrName);

        GenericResponse<List<DropDown>> response = new GenericResponse<>();
        response.setMessage(STATIONS_FETCHED_SUCCESSFULLY);
        response.setResult(stations);
        response.setCount(stations.size());
        response.setStatus(HttpStatus.OK.value());

        log.info("Total stations: {}", stations.size());
        return ResponseEntity.ok(response);
    }
}
