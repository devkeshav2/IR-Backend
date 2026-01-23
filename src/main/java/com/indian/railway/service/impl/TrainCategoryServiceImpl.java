package com.indian.railway.service.impl;

import com.indian.railway.entity.TrainCategory;
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
    public TrainCategory createTrainCategory(TrainCategory trainCategory) {
        return trainCategoryRepository.save(trainCategory);
    }

    @Override
    public List<TrainCategory> getAllTrainCategories() {
        return trainCategoryRepository.findAll();
    }
}
