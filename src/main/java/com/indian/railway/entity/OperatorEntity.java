package com.indian.railway.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(
        name = "operators",
        schema = "railway",
        indexes = {
                @Index(name = "idx_operator_code", columnList = "operator_code")
        }
)
@Data
public class OperatorEntity {

    @Id
    @Column(name = "operator_id", length = 13)
    private String operatorId;

    @Column(name = "operator_code", length = 20, nullable = false, unique = true)
    private String operatorCode;

    @Column(name = "operator_name", length = 100, nullable = false)
    private String operatorName;

    @Column(name = "operator_type", length = 20, nullable = false)
    private String operatorType;
    // GOVERNMENT, PRIVATE

    @Column(name = "country", length = 50, nullable = false)
    private String country="India";

    @Column(name = "contact_email", length = 100)
    private String contactEmail;

    @Column(name = "contact_phone", length = 20)
    private String contactPhone;

    @Column(name = "active", nullable = false)
    private Boolean active = true;
}

