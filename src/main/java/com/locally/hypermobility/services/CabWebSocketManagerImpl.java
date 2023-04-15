package com.locally.hypermobility.services;

import com.locally.hypermobility.domain.CabWebSocketSessionCache;
import com.locally.hypermobility.repositories.CabSessionRepository;
import com.locally.hypermobility.services.interfaces.CabWebSocketManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CabWebSocketManagerImpl implements CabWebSocketManager {

    private final CabSessionRepository cabSessionRepository;

    @Override
    public Mono<CabWebSocketSessionCache> getSessionIdForCab(String cabId) {
        return Mono.just(cabSessionRepository.findById(cabId).get());
    }

    @Override
    public void storeSessionInfo(String sessionId, String cabId) {
        cabSessionRepository.save(
                CabWebSocketSessionCache.builder()
                        .cabId(cabId)
                        .sessionId(sessionId)
                        .build()
        );
    }

    @Override
    public void removeSessionInfo(String cabId) {
        cabSessionRepository.deleteById(cabId);
    }

}
