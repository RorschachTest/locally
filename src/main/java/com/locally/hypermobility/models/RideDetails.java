package com.locally.hypermobility.models;

import lombok.*;
import org.springframework.data.redis.domain.geo.GeoLocation;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RideDetails {

    private GeoLocation pickupPoint;
    private GeoLocation dropPoint;
    private GeoLocation startTime;
    private GeoLocation endTime;
    private RIDE_STATUS status;

    enum RIDE_STATUS {
        RIDE_STATUS,
        PICKUP_PENDING,
        RIDE_IN_PROGRESS,
        RIDE_COMPLETED
    }
}
