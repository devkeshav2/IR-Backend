package com.indian.railway.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TrainLiveStatusId implements Serializable {

    private static final long serialVersionUID = 1L;

    private String trainId;       // FK to Train

    private LocalDate travelDate; // The date of the train's journey
}
