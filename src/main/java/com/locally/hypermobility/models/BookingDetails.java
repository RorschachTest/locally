package com.locally.hypermobility.models;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingDetails {

    private CabDetails cabDetails;
    private RideDetails rideDetails;
    private LocalDateTime estimatePickupTime;
    private LocalDateTime estimateDropTime;
}
