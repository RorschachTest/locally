package com.locally.hypermobility.repositories;

import com.locally.hypermobility.models.CabHexAddress;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface H3CabLocationRepository extends ReactiveCrudRepository<CabHexAddress, String> {

    Flux<CabHexAddress> findAllByH3Index(String h3Index);
}
