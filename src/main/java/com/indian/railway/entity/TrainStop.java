package com.indian.railway.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(
        name = "train_stops",
        schema = "railway",
        indexes = {
                @Index(name = "idx_train_stop_train_id", columnList = "train_id"),
                @Index(name = "idx_train_stop_station_id", columnList = "station_id")
        }
)
@Data
public class TrainStop {

    @EmbeddedId
    private TrainStopId id;

    @ManyToOne
    @MapsId("trainId") // Maps trainId in composite key
    @JoinColumn(name = "train_id", nullable = false)
    private Train train;

    @ManyToOne
    @JoinColumn(name = "station_id", nullable = false)
    private Station station;

    @Column(name = "arrival_time", length = 5)
    private String arrivalTime; // HH:mm format

    @Column(name = "departure_time", length = 5)
    private String departureTime; // HH:mm format

    @Column(name = "distance_from_source")
    private Integer distanceFromSource; // in km

    @Column(name = "halt_time")
    private Integer haltTime; // in minutes

    @Column(name = "platform_code", length = 10)
    private String platformCode; // e.g., "PF1", "PF2A"

    @Column(name = "active", nullable = false)
    private Boolean active = true;
}
