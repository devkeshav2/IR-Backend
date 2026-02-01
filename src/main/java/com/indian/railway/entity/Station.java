package com.indian.railway.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(
        name = "stations",
        schema = "railway",
        indexes = {
                @Index(name = "idx_stations_code", columnList = "station_code"),
                @Index(name = "idx_stations_state", columnList = "state"),
                @Index(name = "idx_stations_city", columnList = "city")
        }
)
@Data
public class Station {

    @Id
    @Column(name = "station_id", length = 13)
    private String stationId;

    @Column(name = "station_code", length = 10, nullable = false, unique = true)
    private String stationCode;

    @Column(name = "station_name", length = 100, nullable = false)
    private String stationName;

    @Column(name = "city", length = 50, nullable = false)
    private String city;

    @Column(name = "state", length = 50, nullable = false)
    private String state;

    @Column(name = "zone", length = 5)
    private String zone;

    @Column(name = "station_type", length = 20)
    private String stationType;

    @Column(name = "platform_count")
    private Integer platformCount;

    @Column(name = "latitude", precision = 10, scale = 7)
    private BigDecimal lat;

    @Column(name = "longitude", precision = 10, scale = 7)
    private BigDecimal lon;

    @Column(name = "timezone", length = 50)
    private String timezone;

    @Column(name = "active", nullable = false)
    private Boolean active = true;


}
