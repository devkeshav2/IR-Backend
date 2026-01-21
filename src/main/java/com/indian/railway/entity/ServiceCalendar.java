package com.indian.railway.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(
        name = "service_calendar",
        schema = "railway",
        indexes = {
                @Index(name = "idx_service_train_id", columnList = "train_id")
        }
)
@Data
public class ServiceCalendar {

    @Id
    @Column(name = "service_id", length = 13)
    private String serviceId;

    @ManyToOne
    @JoinColumn(name = "train_id", nullable = false)
    private Train train;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "monday", nullable = false)
    private Boolean monday = false;

    @Column(name = "tuesday", nullable = false)
    private Boolean tuesday = false;

    @Column(name = "wednesday", nullable = false)
    private Boolean wednesday = false;

    @Column(name = "thursday", nullable = false)
    private Boolean thursday = false;

    @Column(name = "friday", nullable = false)
    private Boolean friday = false;

    @Column(name = "saturday", nullable = false)
    private Boolean saturday = false;

    @Column(name = "sunday", nullable = false)
    private Boolean sunday = false;

    @Column(name = "exceptions", length = 500)
    private String exceptions; // JSON string of special dates

    @Column(name = "active", nullable = false)
    private Boolean active = true;
}

