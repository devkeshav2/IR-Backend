package com.indian.railway.repository;

import com.indian.railway.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrainRepository extends JpaRepository<Train, String> {

    Optional<Train> findByTrainNumber(String trainNumber);

    List<Train> findBySourceStation_StationCodeAndDestinationStation_StationCode(String source, String destination);

    List<Train> findByCategory_CategoryName(String categoryName);

    List<Train> findByActiveTrue();
}

