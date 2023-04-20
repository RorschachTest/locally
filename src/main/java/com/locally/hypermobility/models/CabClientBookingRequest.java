package com.locally.hypermobility.models;

import lombok.Data;
import org.springframework.data.geo.Point;

import java.math.BigDecimal;

@Data
public class CabClientBookingRequest {

    private Point pickupLocation;
    private Point dropLocation;
    private BigDecimal tripCharges;
}
