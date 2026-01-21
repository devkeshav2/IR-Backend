package com.indian.railway.service;

import com.indian.railway.dto.DropDown;
import com.indian.railway.entity.Station;

import java.util.List;

public interface StationService {

    Station saveStation(Station station);

    Station updateStation(Station station);

    void deleteStation(String stationId);

    Station getStationById(String stationId);

    List<Station> getAllStations();

    List<Station> searchStationsByName(String name);

    List<Station> searchStationsByState(String state);

    List<DropDown> getAllStationsInDropDown(String stationCodeOrName);
}
