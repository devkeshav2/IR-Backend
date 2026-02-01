package com.indian.railway.service;

import com.indian.railway.entity.TrainCategoryEntity;

import java.util.List;

public interface TrainCategoryService {
    TrainCategoryEntity createTrainCategory(TrainCategoryEntity trainCategory);

    List<TrainCategoryEntity> getAllTrainCategories();
}
