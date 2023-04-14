package com.locally.hypermobility.bootstrap;

import com.locally.hypermobility.models.CabHexAddress;
import com.locally.hypermobility.repositories.H3CabLocationRepository;
import com.uber.h3core.H3Core;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitializeData implements CommandLineRunner {

    private final H3CabLocationRepository cabLocationRepository;
    private final static Integer UBER_H3_RESOLUTION = 9;
    private final static H3Core h3Core;

    static {
        try {
            h3Core = H3Core.newInstance();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void run(String... args) throws Exception {
        initializeCabHexAddressDb();
    }

    void initializeCabHexAddressDb() throws InterruptedException {
        List.of(
                new Point(17.461395, 78.356649),//home
                new Point(17.458180, 78.372318),//office
                new Point(17.449037, 78.378850),//trident
                new Point(17.434855, 78.341058)//isb road
        ).forEach(point -> {
            cabLocationRepository.save(CabHexAddress.builder()
                    .cabId("rihaz-"+point.toString())
                    .latitude(BigDecimal.valueOf(point.getX()))
                    .longitude(BigDecimal.valueOf(point.getY()))
                    .h3Index(h3Core.latLngToCellAddress(point.getX(), point.getY(), UBER_H3_RESOLUTION))
                    .build()).blockOptional();
        });

        System.out.println(cabLocationRepository.count().block());
    }
}
