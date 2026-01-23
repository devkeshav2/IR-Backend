package com.indian.railway.service;

import com.indian.railway.entity.Operator;
import com.indian.railway.entity.TrainCategory;

import java.util.List;

public interface TrainCategoryService {
    TrainCategory createTrainCategory(TrainCategory trainCategory);

    List<TrainCategory> getAllTrainCategories();
}
