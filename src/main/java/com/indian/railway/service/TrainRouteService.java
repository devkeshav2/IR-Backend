package com.indian.railway.service;

import com.indian.railway.entity.TrainRoute;

import java.util.List;

public interface TrainRouteService {

    TrainRoute addTrainRoute(TrainRoute trainRoute);

    List<TrainRoute> addTrainRouteList(List<TrainRoute> routes);

    List<TrainRoute> getRouteByTrainId(String trainId);

    void deactivateRoute(String trainId);

    List<?> searchTrainsBetweenStations(String sourceStationId, String destinationStationId);
}
