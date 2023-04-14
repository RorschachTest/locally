package com.locally.hypermobility.models;

import lombok.*;
import org.springframework.data.redis.domain.geo.GeoLocation;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CabDetails {
    private String cabId;
    private String canNumber;
    private String contactDetails;
    private GeoLocation currentLocation;

}
