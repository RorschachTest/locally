package com.locally.hypermobility.services;

import com.locally.hypermobility.models.BookingDetails;
import org.springframework.data.redis.domain.geo.GeoLocation;
import org.springframework.stereotype.Service;

@Service
public interface CabFinderService {

    /*
     * bookCabForRider() -> fetchNearbyCabs() -> TripsManagerService()
     * cabsWebSocketManager() -> TripsManagerService() -> RiderService()
     * */
    BookingDetails bookCabForRider(String riderId, GeoLocation pickupLocation, GeoLocation dropLocation);


}
