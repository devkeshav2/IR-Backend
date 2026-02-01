package com.indian.railway.service;

import com.indian.railway.dto.DropDown;
import com.indian.railway.entity.OperatorEntity;

import java.util.List;

public interface OperatorService {
    OperatorEntity createOperator(OperatorEntity operator);

    List<OperatorEntity> getAllOperators();

    List<OperatorEntity> searchOperatorByName(String name);

    List<DropDown> getAllStationsInDropDown(String stationCodeOrName);
}
