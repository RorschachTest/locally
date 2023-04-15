package com.locally.hypermobility.services.interfaces;

import com.locally.hypermobility.models.CabDetails;
import com.locally.hypermobility.models.CabLocation;
import reactor.core.publisher.Flux;

public interface TripsManagerService {

    CabDetails broadcastRideRequestToCabs(Flux<CabLocation> localCabs);

}
