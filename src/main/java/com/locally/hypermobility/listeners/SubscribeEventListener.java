package com.locally.hypermobility.listeners;

import com.locally.hypermobility.services.interfaces.CabWebSocketManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.SimpAttributesContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

@Component
@RequiredArgsConstructor
public class SubscribeEventListener implements ApplicationListener<SessionSubscribeEvent> {

    private final CabWebSocketManager cabWebSocketManager;

    @Override
    public void onApplicationEvent(SessionSubscribeEvent sessionSubscribeEvent) {
        String sessionId = SimpAttributesContextHolder.currentAttributes().getSessionId();
        String user = SimpAttributesContextHolder.currentAttributes().getAttribute("userId").toString();
        System.out.println(user + ":" + sessionId);
        cabWebSocketManager.storeSessionInfo(user, sessionId);
    }
}
