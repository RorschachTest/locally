package com.locally.hypermobility.repositories;

import com.locally.hypermobility.domain.CabWebSocketSessionCache;
import org.springframework.data.repository.CrudRepository;


public interface CabSessionRepository extends CrudRepository<CabWebSocketSessionCache, String> {
}
