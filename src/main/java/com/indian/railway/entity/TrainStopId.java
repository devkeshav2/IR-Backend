package com.indian.railway.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TrainStopId implements Serializable {

    private static final long serialVersionUID = 1L;

    private String trainId;

    private Integer sequenceNo;
}

