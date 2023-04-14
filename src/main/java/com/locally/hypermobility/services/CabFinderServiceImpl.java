package com.locally.hypermobility.services;

import com.locally.hypermobility.models.BookingDetails;
import com.locally.hypermobility.models.CabDetails;
import com.locally.hypermobility.models.CabLocation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.domain.geo.GeoLocation;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class CabFinderServiceImpl implements CabFinderService {

    private final LocationService locationService;
    private final TripsManagerService tripsManagerService;

    /*
     * bookCabForRider() -> fetchNearbyCabs() -> TripsManagerService()
     * cabsWebSocketManager() -> TripsManagerService() -> RiderService()
     * */
    @Override
    public BookingDetails bookCabForRider(String riderId, GeoLocation pickupLocation, GeoLocation dropLocation) {
        Flux<CabLocation> cabDetails = locationService.fetchNearbyCabs(pickupLocation);
        CabDetails bookedCabDetails = tripsManagerService.broadcastRideRequestToCabs(cabDetails);
        return BookingDetails.builder()
                .cabDetails(bookedCabDetails)
                .build();
    }

}
