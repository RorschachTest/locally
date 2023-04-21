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

    @Autowired
    CabSessionRepository cabSessionRepository;
    private final SimpMessagingTemplate messagingTemplate;

//    @MessageMapping("/booking-action")
//    @SendToUser("queue/booking-request")
//    public BookingDetails bookACab(@Payload BookingRequest bookingRequest) {
//        cabFinderService.bookCabForRider(bookingRequest.getRiderId(), bookingRequest.getPickupLocation(),
//                bookingRequest.getDropLocation());
//
//        BookingDetails bookingDetails = BookingDetails.builder().cabDetails(
//                        CabDetails.builder()
//                                .cabNumber("JH-DS-0082-211")
//                                .build()
//                )
//                .build();
//        return bookingDetails;
//    }

    public void bookingRequestToCab(CabClientBookingRequest cabBookingRequest, String sessionId){

        Optional<CabWebSocketSessionCache> cabSession = cabSessionRepository.findById("user");
        messagingTemplate.convertAndSend("/queue/cab-booking-request-user" + cabSession.get().getSessionId(),
                CabClientBookingRequest.builder()
                    .pickupLocation(new Point(3, 1))
                    .dropLocation(new Point(3, 2))
                    .tripCharges(BigDecimal.ONE)
                    .build());
    }

}
