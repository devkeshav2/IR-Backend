package com.indian.railway.service.impl;

import com.indian.railway.entity.Station;
import com.indian.railway.repository.StationRepository;
import com.indian.railway.service.StationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StationServiceImpl implements StationService {

    @Autowired
    private StationRepository stationRepository;

    @Override
    public Station saveStation(Station station) {
        log.info("Saving new station: {}", station);

        if (station.getStationId() == null) {
            String id = String.format("STN%010d", System.currentTimeMillis() % 10000000000L);
            station.setStationId(id);
            log.debug("Generated new station ID: {}", id);
        }

        Station saved = stationRepository.save(station);
        log.info("Station saved successfully with ID: {}", saved.getStationId());
        return saved;
    }

    @Override
    public Station updateStation(Station station) {
        log.info("Updating station with ID: {}", station.getStationId());
        try {
            if (station.getStationId() == null ||
                    !stationRepository.existsById(Long.valueOf(station.getStationId()))) {
                log.warn("Station not found for update: {}", station.getStationId());
                throw new RuntimeException("Station not found for update");
            }

            Station updated = stationRepository.save(station);
            log.info("Station updated successfully: {}", updated);
            return updated;
        } catch (Exception e) {
            log.error("Error while updating station {}: {}", station.getStationId(), e.getMessage());
            throw e;
        }
    }

    @Override
    public void deleteStation(String stationId) {
        log.info("Deleting station with ID: {}", stationId);

        Optional<Station> stationOpt = Optional.ofNullable(stationRepository.findByStationId(stationId));
        if (stationOpt.isPresent()) {
            Station station = stationOpt.get();
            station.setActive(false);
            stationRepository.save(station);
            log.info("Station soft-deleted successfully: {}", stationId);
        } else {
            log.error("Station not found for deletion: {}", stationId);
            throw new RuntimeException("Station not found for deletion");
        }
    }

    @Override
    public Station getStationById(String stationId) {
        log.info("Fetching station by ID: {}", stationId);

        Station station = stationRepository.findByStationId(stationId);
        if (station != null) {
            log.debug("Found station: {}", station);
        } else {
            log.warn("No station found with ID: {}", stationId);
        }
        return station;
    }

    @Override
    public List<Station> getAllStations() {
        log.info("Fetching all stations");
        List<Station> stations = stationRepository.findAll();
        log.debug("Total stations found: {}", stations.size());
        return stations;
    }

    @Override
    public List<Station> searchStationsByName(String name) {
        log.info("Searching stations by name: {}", name);
        List<Station> found = stationRepository.findByStationNameContainingIgnoreCase(name);
        log.debug("Stations found by name '{}': {}", name, found.size());
        return found;
    }

    @Override
    public List<Station> searchStationsByState(String state) {
        log.info("Searching stations by state: {}", state);
        List<Station> found = stationRepository.findByStateIgnoreCase(state);
        log.debug("Stations found in state '{}': {}", state, found.size());
        return found;
    }
}
