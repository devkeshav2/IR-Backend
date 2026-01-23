package com.indian.railway.repository;

import com.indian.railway.entity.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, String> {
    List<Operator> findAllByOperatorName(String name);
}
