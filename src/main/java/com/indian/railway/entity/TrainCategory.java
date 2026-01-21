package com.indian.railway.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(
        name = "train_category",
        schema = "railway",
        indexes = {
                @Index(name = "idx_train_category_code", columnList = "category_code")
        }
)
@Data
public class TrainCategory {

    @Id
    @Column(name = "category_id", length = 13)
    private String categoryId;

    @Column(name = "category_code", length = 20, nullable = false, unique = true)
    private String categoryCode;

    @Column(name = "category_name", length = 50, nullable = false)
    private String categoryName;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "max_speed")
    private Integer maxSpeed;

    @Column(name = "active", nullable = false)
    private Boolean active = true;
}

