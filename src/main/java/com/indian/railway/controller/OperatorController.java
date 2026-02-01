package com.indian.railway.controller;

import com.indian.railway.common.GenericResponse;
import com.indian.railway.entity.OperatorEntity;
import com.indian.railway.service.OperatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(OPERATOR_BASE_URL)
@PreAuthorize("hasRole('ADMIN')")
public class OperatorController {

    @Autowired
    private OperatorService operatorService;

    @PostMapping
    public ResponseEntity<GenericResponse<OperatorEntity>> createOperator(@RequestBody OperatorEntity operator) {
        log.info("Create operator request: {}", operator);
        OperatorEntity saved = operatorService.createOperator(operator);

        GenericResponse<OperatorEntity> response = new GenericResponse<>();
        response.setMessage(OPERATOR_CREATED_SUCCESSFULLY);
        response.setResult(saved);
        response.setCount(1);
        response.setStatus(HttpStatus.CREATED.value());

        log.info("Operator created: {}", saved.getOperatorId());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<GenericResponse<List<OperatorEntity>>> getAllOperators() {
        log.info("Get all operators request");
        List<OperatorEntity> Operators = operatorService.getAllOperators();

        GenericResponse<List<OperatorEntity>> response = new GenericResponse<>();
        response.setMessage(OPERATORS_FETCHED_SUCCESSFULLY);
        response.setResult(Operators);
        response.setCount(Operators.size());
        response.setStatus(HttpStatus.OK.value());

        log.info("Total Operators: {}", Operators.size());
        return ResponseEntity.ok(response);
    }
}
