package com.indian.railway.controller;

import com.indian.railway.common.GenericResponse;
import com.indian.railway.entity.TrainCategoryEntity;
import com.indian.railway.service.TrainCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.indian.railway.common.APIConstants.TRAINCATEGORY_BASE_URL;
import static com.indian.railway.common.IRResponseConstants.*;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping(TRAINCATEGORY_BASE_URL)
@PreAuthorize("hasRole('ADMIN')")
public class TrainCatogaryController {
    @Autowired
    private TrainCategoryService trainCategoryService;

    @PostMapping
    public ResponseEntity<GenericResponse<TrainCategoryEntity>> createTrainCategory(@RequestBody TrainCategoryEntity TrainCategory) {
        log.info("Create TrainCategory request: {}", TrainCategory);
        TrainCategoryEntity saved = trainCategoryService.createTrainCategory(TrainCategory);

        GenericResponse<TrainCategoryEntity> response = new GenericResponse<>();
        response.setMessage(TRAINCATEGORY_CREATED_SUCCESSFULLY);
        response.setResult(saved);
        response.setCount(1);
        response.setStatus(HttpStatus.CREATED.value());

        log.info("TrainCategory created: {}", saved.getCategoryId());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<GenericResponse<List<TrainCategoryEntity>>> getAllTrainCategorys() {
        log.info("Get all TrainCategorys request");
        List<TrainCategoryEntity> TrainCategorys = trainCategoryService.getAllTrainCategories();

        GenericResponse<List<TrainCategoryEntity>> response = new GenericResponse<>();
        response.setMessage(TRAINCATEGORY_FETCHED_SUCCESSFULLY);
        response.setResult(TrainCategorys);
        response.setCount(TrainCategorys.size());
        response.setStatus(HttpStatus.OK.value());

        log.info("Total TrainCategorys: {}", TrainCategorys.size());
        return ResponseEntity.ok(response);
    }
    
}
