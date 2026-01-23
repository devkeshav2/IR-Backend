package com.indian.railway.service;

import com.indian.railway.dto.DropDown;
import com.indian.railway.entity.Operator;

import java.util.List;

public interface OperatorService {
    Operator createOperator(Operator operator);

    List<Operator> getAllOperators();

    List<Operator> searchOperatorByName(String name);

    List<DropDown> getAllStationsInDropDown(String stationCodeOrName);
}
