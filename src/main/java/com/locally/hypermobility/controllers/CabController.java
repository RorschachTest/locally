package com.locally.hypermobility.controllers;

import com.locally.hypermobility.domain.CabWebSocketSessionCache;
import com.locally.hypermobility.models.CabClientBookingRequest;
import com.locally.hypermobility.repositories.CabSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CabController {

    static Integer bookingId = 123;
    @Autowired
    CabSessionRepository cabSessionRepository;
    private final SimpMessagingTemplate messagingTemplate;

    public void bookingRequestToCab(CabClientBookingRequest cabBookingRequest, String sessionId){
        bookingId++;
        Optional<CabWebSocketSessionCache> cabSession = cabSessionRepository.findById("user");
        messagingTemplate.convertAndSend("/queue/cab-booking-request-user" + cabSession.get().getSessionId(),
                CabClientBookingRequest.builder()
                    .bookingId(String.valueOf(bookingId))
                    .pickupLocation(new Point(3, 1))
                    .dropLocation(new Point(3, 2))
                    .tripCharges(BigDecimal.ONE)
                    .build());
    }

}
