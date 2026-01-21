package com.indian.railway.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "train_live_status",
        schema = "railway",
        indexes = {
                @Index(name = "idx_live_status_train_date", columnList = "train_id, travel_date")
        }
)
@Data
public class TrainLiveStatus {

    @EmbeddedId
    private TrainLiveStatusId id;

    @ManyToOne
    @MapsId("trainId") // Maps trainId in composite key
    @JoinColumn(name = "train_id", nullable = false)
    private Train train;

    @Column(name = "actual_departure_time")
    private LocalDateTime actualDepartureTime;

    @Column(name = "actual_arrival_time")
    private LocalDateTime actualArrivalTime;

    @Column(name = "delay_minutes")
    private Integer delayMinutes; // Total delay in minutes

    @Column(name = "current_station_id", length = 13)
    private String currentStationId; // Current station

    @Column(name = "next_station_id", length = 13)
    private String nextStationId; // Next station

    @Column(name = "eta_datetime")
    private LocalDateTime etaDateTime; // Estimated arrival at next station

    @Column(name = "status", length = 20)
    private String status; // ON_TIME, DELAYED, CANCELLED, ARRIVED

    @Column(name = "remarks", length = 255)
    private String remarks; // Optional notes

    @Column(name = "active", nullable = false)
    private Boolean active = true;
}
