package com.locally.hypermobility.services;

import com.locally.hypermobility.models.BookingDetails;
import com.locally.hypermobility.models.CabDetails;
import com.locally.hypermobility.models.CabLocation;
import com.locally.hypermobility.services.interfaces.CabFinderService;
import com.locally.hypermobility.services.interfaces.LocationService;
import com.locally.hypermobility.services.interfaces.TripsManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.geo.Point;
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
    public BookingDetails bookCabForRider(String riderId, Point pickupLocation, Point dropLocation) {
        Flux<CabLocation> cabDetails = locationService.fetchNearbyCabs(pickupLocation);
        CabDetails bookedCabDetails = tripsManagerService.broadcastRideRequestToCabs(cabDetails);
        return BookingDetails.builder()
                .cabDetails(bookedCabDetails)
                .build();
    }

}
