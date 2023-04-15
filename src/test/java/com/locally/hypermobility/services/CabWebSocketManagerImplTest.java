package com.locally.hypermobility.services;

import com.locally.hypermobility.domain.CabWebSocketSessionCache;
import com.locally.hypermobility.repositories.CabSessionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

//@DataJpaTest
//@Import(SocketManagerRedisCacheConfig.class) TODO: run this test with test-data-splice
@SpringBootTest
class CabWebSocketManagerImplTest {

    public static final CabWebSocketSessionCache cabSessionCache =
            CabWebSocketSessionCache.builder()
                    .sessionId("fdasf3q4fd")
                    .cabId("sdfsf232")
                    .build();
    @Autowired
    CabSessionRepository cabSessionRepository;
    @Test
    void getSessionIdForCab() {
        //given
        cabSessionRepository.save(cabSessionCache);
        //when
        Optional<CabWebSocketSessionCache> cabSessionCacheOptional =
                cabSessionRepository.findById(cabSessionCache.getCabId());
        //then
        assert !cabSessionCacheOptional.isEmpty();
        System.out.println(cabSessionCacheOptional.get());
    }
}