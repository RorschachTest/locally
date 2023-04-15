package com.locally.hypermobility.services;

import com.locally.hypermobility.models.CabLocation;
import com.locally.hypermobility.services.interfaces.LocationService;
import com.locally.hypermobility.services.interfaces.MapsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final MapsService mapsService;

    @Override
    public Flux<CabLocation> fetchNearbyCabs(Point pickupLocation) {
        return mapsService.fetchNearbyCabs(pickupLocation);
    }
}
