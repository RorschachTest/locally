package com.locally.hypermobility.services.interfaces;

import com.locally.hypermobility.models.BookingDetails;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;


@Service
public interface CabFinderService {

    /*
     * bookCabForRider() -> fetchNearbyCabs() -> TripsManagerService()
     * cabsWebSocketManager() -> TripsManagerService() -> RiderService()
     * */
    BookingDetails bookCabForRider(String riderId, Point pickupLocation, Point dropLocation);


}
