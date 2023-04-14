package com.locally.hypermobility.services;

import com.locally.hypermobility.models.CabDetails;
import com.locally.hypermobility.models.CabLocation;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class BasicTripsManagerService implements TripsManagerService {
    @Override
    public CabDetails broadcastRideRequestToCabs(Flux<CabLocation> localCabs) {
        return null;
    }
}
