package com.locally.hypermobility.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {

    private String riderId;
    private Point pickupLocation;
    private Point dropLocation;
}
