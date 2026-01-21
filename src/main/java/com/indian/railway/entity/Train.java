package com.indian.railway.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(
        name = "train",
        schema = "railway",
        indexes = {
                @Index(name = "idx_train_number", columnList = "train_number"),
                @Index(name = "idx_train_name", columnList = "train_name")
        }
)
@Data
public class Train {

    @Id
    @Column(name = "train_id", length = 13)
    private String trainId;

    @Column(name = "train_number", length = 10, nullable = false)
    private String trainNumber;

    @Column(name = "train_name", length = 100, nullable = false)
    private String trainName;

    @ManyToOne
    @JoinColumn(name = "operator_id", nullable = false)
    private Operator operator;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private TrainCategory category;

    @ManyToOne
    @JoinColumn(name = "source_station_id")
    private Station sourceStation;

    @ManyToOne
    @JoinColumn(name = "destination_station_id")
    private Station destinationStation;

    @Column(name = "average_speed")
    private Integer averageSpeed;

    @Column(name = "return_train_number")
    private String returnTrainNumber;

    @Column(name = "total_distance_km")
    private Integer totalDistanceKm;

    @Column(name = "journey_duration_minutes")
    private Integer journeyDurationMinutes;

    @Column(name = "remarks", length = 255)
    private String remarks;

    @Column(name = "active", nullable = false)
    private Boolean active = true;
}

