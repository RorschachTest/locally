package com.locally.hypermobility.listeners;

import com.locally.hypermobility.services.interfaces.CabWebSocketManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class SubscribeEventListener implements ApplicationListener<SessionSubscribeEvent> {

    private final CabWebSocketManager cabWebSocketManager;

    @Override
    public void onApplicationEvent(SessionSubscribeEvent sessionSubscribeEvent) {
        Map<String, Object> headerAccessor = StompHeaderAccessor.wrap(sessionSubscribeEvent.getMessage()).getSessionAttributes();

        cabWebSocketManager.storeSessionInfo(headerAccessor.get("sessionId").toString(),
                "");
    }
}
