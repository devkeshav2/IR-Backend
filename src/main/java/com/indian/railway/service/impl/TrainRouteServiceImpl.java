package com.indian.railway.service.impl;

import com.indian.railway.entity.TrainRoute;
import com.indian.railway.repository.TrainRouteRepository;
import com.indian.railway.service.TrainRouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TrainRouteServiceImpl implements TrainRouteService {

    private final TrainRouteRepository trainRouteRepository;

    @Override
    public TrainRoute addTrainRoute(TrainRoute trainRoute) {
        return trainRouteRepository.save(trainRoute);
    }

    @Override
    public List<TrainRoute> addTrainRouteList(List<TrainRoute> routes) {
        return trainRouteRepository.saveAll(routes);
    }

    @Override
    public List<TrainRoute> getRouteByTrainId(String trainId) {
        return trainRouteRepository.findActiveRouteByTrain(trainId);
    }

    @Override
    public void deactivateRoute(String trainId) {
        List<TrainRoute> routes =
                trainRouteRepository.findByTrain_TrainIdOrderById_StopNumber(trainId);

        routes.forEach(route -> route.setActive(false));
        trainRouteRepository.saveAll(routes);
    }

    @Override
    public List<?> searchTrainsBetweenStations(
            String sourceStationId,
            String destinationStationId
    ) {
        return trainRouteRepository.findTrainsBetweenStations(
                sourceStationId,
                destinationStationId
        );
    }
}
