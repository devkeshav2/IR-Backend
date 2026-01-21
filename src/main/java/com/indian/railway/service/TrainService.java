package com.indian.railway.service;

import com.indian.railway.common.GenericResponse;
import com.indian.railway.entity.Train;

import java.util.List;

public interface TrainService {

    GenericResponse<Train> createTrain(Train train);

    GenericResponse<Train> updateTrain(String trainId, Train train);

    GenericResponse<Train> getTrainById(String trainId);

    GenericResponse<Train> getTrainByNumber(String trainNumber);

    GenericResponse<List<Train>> getAllTrains();

    GenericResponse<List<Train>> getActiveTrains();

    GenericResponse<List<Train>> searchTrains(String sourceCode, String destinationCode);

    GenericResponse<List<Train>> getTrainsByCategory(String categoryName);

    GenericResponse<Void> deleteTrain(String trainId);

    GenericResponse<Void> deactivateTrain(String trainId);
}

