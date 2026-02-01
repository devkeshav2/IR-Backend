package com.indian.railway.service.impl;

import com.indian.railway.entity.TrainCategoryEntity;
import com.indian.railway.repository.TrainCategoryRepository;
import com.indian.railway.service.TrainCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TrainCategoryServiceImpl implements TrainCategoryService {

    @Autowired
    private TrainCategoryRepository trainCategoryRepository;

    @Override
    public TrainCategoryEntity createTrainCategory(TrainCategoryEntity trainCategory) {
        return trainCategoryRepository.save(trainCategory);
    }

    @Override
    public List<TrainCategoryEntity> getAllTrainCategories() {
        return trainCategoryRepository.findAll();
    }
}
