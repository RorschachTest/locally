package com.locally.hypermobility.models;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BookingDetails {

    private String test;
    private CabDetails cabDetails;
    private RideDetails rideDetails;
    private LocalDateTime estimatePickupTime;
    private LocalDateTime estimateDropTime;
}
