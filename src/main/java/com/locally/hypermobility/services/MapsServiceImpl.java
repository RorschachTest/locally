package com.locally.hypermobility.services;

import com.locally.hypermobility.models.CabDetails;
import com.locally.hypermobility.models.CabHexAddress;
import com.locally.hypermobility.models.CabLocation;
import com.locally.hypermobility.repositories.H3CabLocationRepository;
import com.uber.h3core.H3Core;
import com.uber.h3core.util.LatLng;
import lombok.RequiredArgsConstructor;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.domain.geo.GeoLocation;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MapsServiceImpl implements MapsService {

    private static final Integer UBER_H3_RESOLUTION = 9;
    private static H3Core h3Core;

    private final H3CabLocationRepository repository;

    static {
        try {
            h3Core = H3Core.newInstance();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Flux<CabLocation> fetchNearbyCabs(GeoLocation pickupLocation) {
        Point pickupPoint = pickupLocation.getPoint();
        String h3Index = h3Core.latLngToCellAddress(pickupPoint.getX(), pickupPoint.getY(), UBER_H3_RESOLUTION);

        return repository.findAllByH3Index(h3Index).map(cabHexAddress ->
                CabLocation.builder()
                    .location(new LatLng(cabHexAddress.getLatitude().doubleValue(), cabHexAddress.getLongitude().doubleValue()))
                    .build());
    }

    @Override
    public void updateCabCurrentLocation(String cabId, GeoLocation currentLocation) {
        String h3Index = h3Core.latLngToCellAddress(
                currentLocation.getPoint().getX(), currentLocation.getPoint().getY(), UBER_H3_RESOLUTION);
        repository.save(
                CabHexAddress.builder()
                        .cabId(cabId)
                        .h3Index(h3Index)
                        .latitude(BigDecimal.valueOf(currentLocation.getPoint().getX()))
                        .longitude(BigDecimal.valueOf(currentLocation.getPoint().getY()))
                        .build()
        );
    }

    @Override
    public void bulkCabLocationWrite(List<CabDetails> cabs) {

    }
}
