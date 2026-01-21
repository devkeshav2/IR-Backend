package com.indian.railway.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "fare_policy",
        schema = "railway",
        indexes = {
                @Index(name = "idx_fare_policy_name", columnList = "name")
        }
)
@Data
public class FarePolicy {

    @Id
    @Column(name = "policy_id", length = 13)
    private String policyId; // FAP0000000001

    @Column(name = "name", length = 100, nullable = false, unique = true)
    private String name; // e.g., "Standard Fare"

    @Column(name = "currency_code", length = 5, nullable = false)
    private String currencyCode; // INR, USD

    @Column(name = "base_per_km", precision = 10, scale = 2, nullable = false)
    private BigDecimal basePerKm; // Fare per km

    @Column(name = "active", nullable = false)
    private Boolean active = true;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
