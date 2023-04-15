package com.locally.hypermobility.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("cab-session")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CabWebSocketSessionCache {

    @Id
    String cabId;
    String sessionId;

}
