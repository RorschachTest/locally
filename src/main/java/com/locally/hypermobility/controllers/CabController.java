package com.locally.hypermobility.controllers;

import com.locally.hypermobility.models.BookingDetails;
import com.locally.hypermobility.models.BookingRequest;
import com.locally.hypermobility.models.CabDetails;
import com.locally.hypermobility.services.interfaces.CabFinderService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CabController {

    private final CabFinderService cabFinderService;

    @MessageMapping("/booking-action")
    @SendToUser("queue/booking-request")
    public BookingDetails bookACab(@Payload BookingRequest bookingRequest) {
        cabFinderService.bookCabForRider(bookingRequest.getRiderId(), bookingRequest.getPickupLocation(),
                bookingRequest.getDropLocation());

        BookingDetails bookingDetails = BookingDetails.builder().cabDetails(
                        CabDetails.builder()
                                .cabNumber("JH-DS-0082-211")
                                .build()
                )
                .build();
        return bookingDetails;
    }

}
