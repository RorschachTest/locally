package com.locally.hypermobility.services;

import com.locally.hypermobility.models.CabLocation;
import org.springframework.data.redis.domain.geo.GeoLocation;
import reactor.core.publisher.Flux;

public interface LocationService {


    Flux<CabLocation> fetchNearbyCabs(GeoLocation pickupLocation);
}
