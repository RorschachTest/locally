package com.locally.hypermobility.services;

import com.locally.hypermobility.domain.CabWebSocketSessionCache;
import com.locally.hypermobility.models.CabDetails;
import com.locally.hypermobility.models.CabLocation;
import com.locally.hypermobility.services.interfaces.CabWebSocketManager;
import com.locally.hypermobility.services.interfaces.TripsManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class BasicTripsManagerService implements TripsManagerService {

    private final CabWebSocketManager cabWebSocketManager;

    @Override
    public CabDetails broadcastRideRequestToCabs(Flux<CabLocation> localCabs) {
        Flux<CabWebSocketSessionCache> cabSessions =
                localCabs.flatMap(cabLocation -> cabWebSocketManager.getSessionIdForCab(cabLocation.getCabId()));


        return null;
    }
}
