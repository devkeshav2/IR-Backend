package com.indian.railway.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class TrainRouteId implements Serializable {

    @Column(name = "train_id")
    private String trainId;

    @Column(name = "stop_number")
    private Integer stopNumber;
}
