package com.locally.hypermobility.services;

import com.locally.hypermobility.models.CabLocation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.domain.geo.GeoLocation;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final MapsService mapsService;

    @Override
    public Flux<CabLocation> fetchNearbyCabs(GeoLocation pickupLocation) {
        return mapsService.fetchNearbyCabs(pickupLocation);
    }
}
