package com.locally.hypermobility.services.interfaces;

import com.locally.hypermobility.models.CabLocation;
import org.springframework.data.geo.Point;
import reactor.core.publisher.Flux;

public interface LocationService {


    Flux<CabLocation> fetchNearbyCabs(Point pickupLocation);
}
