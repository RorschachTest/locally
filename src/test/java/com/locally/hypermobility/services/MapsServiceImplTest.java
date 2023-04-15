package com.locally.hypermobility.services;

import com.locally.hypermobility.domain.CabHexAddress;
import com.locally.hypermobility.repositories.H3CabLocationRepository;
import com.locally.hypermobility.util.CabDataUtil;
import com.uber.h3core.H3Core;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;


@SpringBootTest
class MapsServiceImplTest {

    @Autowired
    H3CabLocationRepository locationRepository;

    private final static Integer UBER_H3_RESOLUTION = 9;

    private final static H3Core h3Core;

    static {
        try {
            h3Core = H3Core.newInstance();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void fetchNearbyCabs() {
        String hexAddress = h3Core.latLngToCellAddress(CabDataUtil.rider.getX(), CabDataUtil.rider.getX(), UBER_H3_RESOLUTION);
        CabHexAddress cabHexAddress = locationRepository.findAllByH3Index(hexAddress).blockFirst();
        assert cabHexAddress == null;
    }
}