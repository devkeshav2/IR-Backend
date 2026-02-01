package com.indian.railway.repository;

import com.indian.railway.entity.OperatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperatorRepository extends JpaRepository<OperatorEntity, String> {
    List<OperatorEntity> findAllByOperatorName(String name);
}
