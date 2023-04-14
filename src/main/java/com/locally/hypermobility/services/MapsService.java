package com.locally.hypermobility.services;

import com.locally.hypermobility.models.CabDetails;
import com.locally.hypermobility.models.CabLocation;
import org.springframework.data.geo.Point;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.util.List;

public interface MapsService {

    Flux<CabLocation> fetchNearbyCabs(Point pickupLocation);

    void updateCabCurrentLocation(String cabId, Point currentLocation) throws IOException;
    void bulkCabLocationWrite(List<CabDetails> cabs);
}
