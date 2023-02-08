package com.example.liveeasylogisticassessment.Entity;

import jakarta.persistence.*;
import lombok.Data;


import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class Loads {
    private String loadingPoint;
    private String unloadingPoint;
    private String productType;
    private String truckType;
    private String noOfTrucks;
    private String weight;
    private String comment;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID shipperId;
    private Date Date;
}
