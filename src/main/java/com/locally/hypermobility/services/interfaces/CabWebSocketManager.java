package com.locally.hypermobility.services.interfaces;

import com.locally.hypermobility.domain.CabWebSocketSessionCache;
import reactor.core.publisher.Mono;

public interface CabWebSocketManager {

    Mono<CabWebSocketSessionCache> getSessionIdForCab(String cabId);

    void storeSessionInfo(String sessionId, String cabId);

    void removeSessionInfo(String cabId);

}
