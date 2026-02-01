package com.indian.railway.repository;

import com.indian.railway.entity.TrainCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainCategoryRepository extends JpaRepository<TrainCategoryEntity, String> {
}
