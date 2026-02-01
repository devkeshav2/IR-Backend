package com.indian.railway.service.impl;

import com.indian.railway.dto.DropDown;
import com.indian.railway.entity.OperatorEntity;
import com.indian.railway.repository.OperatorRepository;
import com.indian.railway.service.OperatorService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OperatorServiceImpl implements OperatorService {

    @Resource
    private OperatorRepository operatorRepository;


    @Override
    public OperatorEntity createOperator(OperatorEntity operator) {
        return operatorRepository.save(operator);
    }

    @Override
    public List<OperatorEntity> getAllOperators() {
        return operatorRepository.findAll();
    }

    @Override
    public List<OperatorEntity> searchOperatorByName(String name) {
        return operatorRepository.findAllByOperatorName(name);
    }

    @Override
    public List<DropDown> getAllStationsInDropDown(String stationCodeOrName) {
        return List.of();
    }
}
