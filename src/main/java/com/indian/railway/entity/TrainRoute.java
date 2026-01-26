package com.indian.railway.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
@Entity
@Table(
        name = "train_route",
        schema = "railway",
        indexes = {
                @Index(name = "idx_train_route_train_id", columnList = "train_id"),
                @Index(name = "idx_train_route_station_id", columnList = "station_id")
        }
)
@Data
public class TrainRoute {

    @EmbeddedId
    private TrainRouteId id;

    /* ===============================
       RELATIONSHIPS
       =============================== */

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("trainId")
    @JoinColumn(name = "train_id", nullable = false)
    private Train train;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id", nullable = false)
    private Station station;

    /* ===============================
       ROUTE DETAILS
       =============================== */

    @Column(name = "arrival_time")
    private LocalTime arrivalTime;

    @Column(name = "departure_time")
    private LocalTime departureTime;

    @Column(name = "day_number", nullable = false)
    private Integer dayNumber;

    @Column(name = "distance_from_source")
    private Integer distanceFromSource;

    @Column(name = "halt_time")
    private Integer haltTime;

    @Column(name = "platform_code", length = 10)
    private String platformCode;

    @Column(name = "is_source", nullable = false)
    private Boolean source = false;

    @Column(name = "is_destination", nullable = false)
    private Boolean destination = false;

    @Column(name = "active", nullable = false)
    private Boolean active = true;
}
