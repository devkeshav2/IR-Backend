package com.indian.railway.repository;

import com.indian.railway.entity.TrainCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainCategoryRepository extends JpaRepository<TrainCategory, String> {
}
