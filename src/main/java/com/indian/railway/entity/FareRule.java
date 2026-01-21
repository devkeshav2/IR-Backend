package com.indian.railway.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(
        name = "fare_rule",
        schema = "railway",
        indexes = {
                @Index(name = "idx_fare_rule_policy_class", columnList = "policy_id, travel_class")
        }
)
@Data
public class FareRule {

    @Id
    @Column(name = "rule_id", length = 13)
    private String ruleId; // FAR0000000001

    @ManyToOne
    @JoinColumn(name = "policy_id", nullable = false)
    private FarePolicy farePolicy;

    @Column(name = "travel_class", length = 10, nullable = false)
    private String travelClass; // SL, 3A, 2A, CC

    @Column(name = "min_km", nullable = false)
    private Integer minKm; // starting distance of slab

    @Column(name = "max_km", nullable = false)
    private Integer maxKm; // ending distance of slab

    @Column(name = "slab_rate", precision = 10, scale = 2, nullable = false)
    private BigDecimal slabRate; // Rate per km for this slab

    @Column(name = "multiplier", precision = 5, scale = 2, nullable = false)
    private BigDecimal multiplier; // Class-based or special multiplier

    @Column(name = "active", nullable = false)
    private Boolean active = true;
}
