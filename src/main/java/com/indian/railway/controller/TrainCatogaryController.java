package com.indian.railway.controller;

import com.indian.railway.common.GenericResponse;
import com.indian.railway.entity.TrainCategory;
import com.indian.railway.service.TrainCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.indian.railway.common.IRConstants.*;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping(TRAINCATEGORY_BASE_URL)
@PreAuthorize("hasRole('ADMIN')")
public class TrainCatogaryController {
    @Autowired
    private TrainCategoryService trainCategoryService;

    @PostMapping
    public ResponseEntity<GenericResponse<TrainCategory>> createTrainCategory(@RequestBody TrainCategory TrainCategory) {
        log.info("Create TrainCategory request: {}", TrainCategory);
        TrainCategory saved = trainCategoryService.createTrainCategory(TrainCategory);

        GenericResponse<TrainCategory> response = new GenericResponse<>();
        response.setMessage(TRAINCATEGORY_CREATED_SUCCESSFULLY);
        response.setResult(saved);
        response.setCount(1);
        response.setStatus(HttpStatus.CREATED.value());

        log.info("TrainCategory created: {}", saved.getCategoryId());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<GenericResponse<List<TrainCategory>>> getAllTrainCategorys() {
        log.info("Get all TrainCategorys request");
        List<TrainCategory> TrainCategorys = trainCategoryService.getAllTrainCategories();

        GenericResponse<List<TrainCategory>> response = new GenericResponse<>();
        response.setMessage(TRAINCATEGORY_FETCHED_SUCCESSFULLY);
        response.setResult(TrainCategorys);
        response.setCount(TrainCategorys.size());
        response.setStatus(HttpStatus.OK.value());

        log.info("Total TrainCategorys: {}", TrainCategorys.size());
        return ResponseEntity.ok(response);
    }
    
}
