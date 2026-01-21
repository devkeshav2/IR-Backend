package com.indian.railway.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(
        name = "service_exception",
        schema = "railway",
        indexes = {
                @Index(name = "idx_exception_service_date", columnList = "service_id, exception_date")
        }
)
@Data
public class ServiceException {

    @Id
    @Column(name = "exception_id", length = 13)
    private String exceptionId; // SEX0000000001

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private ServiceCalendar serviceCalendar;

    @Column(name = "exception_date", nullable = false)
    private LocalDate exceptionDate;

    @Column(name = "exception_type", length = 10, nullable = false)
    private String exceptionType; // ADDED / REMOVED

    @Column(name = "reason", length = 255)
    private String reason;

    @Column(name = "active", nullable = false)
    private Boolean active = true;
}

