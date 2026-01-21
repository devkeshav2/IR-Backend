package com.indian.railway.service.impl;

import com.indian.railway.common.GenericResponse;
import com.indian.railway.entity.Train;
import com.indian.railway.repository.TrainRepository;
import com.indian.railway.service.TrainService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class TrainServiceImpl implements TrainService {

    private final TrainRepository trainRepository;

    @Override
    public GenericResponse<Train> createTrain(Train train) {
        log.info("Creating train: {}", train.getTrainNumber());
        Train saved = trainRepository.save(train);
        return new GenericResponse<>("Train created successfully", saved, 1, 201);
    }

    @Override
    public GenericResponse<Train> updateTrain(String trainId, Train train) {
        log.info("Updating train with id {}", trainId);
        Train existing = trainRepository.findById(trainId)
                .orElseThrow(() -> new RuntimeException("Train not found"));
        train.setTrainId(existing.getTrainId());
        Train updated = trainRepository.save(train);
        return new GenericResponse<>("Train updated successfully", updated, 1, 200);
    }

    @Override
    public GenericResponse<Train> getTrainById(String trainId) {
        log.info("Fetching train by id {}", trainId);
        Train train = trainRepository.findById(trainId)
                .orElseThrow(() -> new RuntimeException("Train not found"));
        return new GenericResponse<>("Train fetched successfully", train, 1, 200);
    }

    @Override
    public GenericResponse<Train> getTrainByNumber(String trainNumber) {
        log.info("Fetching train by number {}", trainNumber);
        Train train = trainRepository.findByTrainNumber(trainNumber)
                .orElseThrow(() -> new RuntimeException("Train not found"));
        return new GenericResponse<>("Train fetched successfully", train, 1, 200);
    }

    @Override
    public GenericResponse<List<Train>> getAllTrains() {
        log.info("Fetching all trains");
        List<Train> trains = trainRepository.findAll();
        return new GenericResponse<>("All trains fetched", trains, trains.size(), 200);
    }

    @Override
    public GenericResponse<List<Train>> getActiveTrains() {
        log.info("Fetching active trains");
        List<Train> trains = trainRepository.findByActiveTrue();
        return new GenericResponse<>("Active trains fetched", trains, trains.size(), 200);
    }

    @Override
    public GenericResponse<List<Train>> searchTrains(String sourceCode, String destinationCode) {
        log.info("Searching trains from {} to {}", sourceCode, destinationCode);
        List<Train> trains = trainRepository
                .findBySourceStation_StationCodeAndDestinationStation_StationCode(sourceCode, destinationCode);
        return new GenericResponse<>("Trains found", trains, trains.size(), 200);
    }

    @Override
    public GenericResponse<List<Train>> getTrainsByCategory(String categoryName) {
        log.info("Fetching trains by category {}", categoryName);
        List<Train> trains = trainRepository.findByCategory_CategoryName(categoryName);
        return new GenericResponse<>("Trains fetched by category", trains, trains.size(), 200);
    }

    @Override
    public GenericResponse<Void> deleteTrain(String trainId) {
        log.warn("Deleting train with id {}", trainId);
        trainRepository.deleteById(trainId);
        return new GenericResponse<>("Train deleted successfully", null, 0, 200);
    }

    @Override
    public GenericResponse<Void> deactivateTrain(String trainId) {
        log.warn("Deactivating train with id {}", trainId);
        Train train = trainRepository.findById(trainId)
                .orElseThrow(() -> new RuntimeException("Train not found"));
        train.setActive(false);
        trainRepository.save(train);
        return new GenericResponse<>("Train deactivated successfully", null, 0, 200);
    }
}

