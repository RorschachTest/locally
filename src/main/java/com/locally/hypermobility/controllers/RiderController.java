package com.locally.hypermobility.controllers;

import com.locally.hypermobility.models.BookingDetails;
import com.locally.hypermobility.models.BookingRequest;
import com.locally.hypermobility.models.CabDetails;
import com.locally.hypermobility.services.CabFinderService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@MessageMapping("api/v1/rider")
@RequiredArgsConstructor
public class RiderController {

    private final CabFinderService cabFinderService;

    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/message")
    public void bookACab(
            @Header("simpSessionId") String sessionId,
            @Payload BookingRequest bookingRequest) {
        cabFinderService.bookCabForRider(bookingRequest.getRiderId(), bookingRequest.getPickupLocation(),
                bookingRequest.getDropLocation());

        BookingDetails bookingDetails = BookingDetails.builder().cabDetails(
                        CabDetails.builder()
                                .cabNumber("JH-DS-0082-211")
                                .build()
                )
                .build();

        simpMessagingTemplate.convertAndSend("/queue/greeting-" + sessionId, bookingDetails);
    }

}
