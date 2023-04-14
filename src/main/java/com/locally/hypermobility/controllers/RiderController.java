package com.locally.hypermobility.controllers;

import com.locally.hypermobility.models.BookingDetails;
import com.locally.hypermobility.models.BookingRequest;
import com.locally.hypermobility.models.CabDetails;
import com.locally.hypermobility.services.CabFinderService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
@MessageMapping("api/v1/rider")
@RequiredArgsConstructor
public class RiderController {

    private final CabFinderService cabFinderService;

    @MessageMapping("/book-cab")
    @SendTo("/topic/book-cab")
    public BookingDetails bookACab(BookingRequest bookingRequest) {
        cabFinderService.bookCabForRider(bookingRequest.getRiderId(), bookingRequest.getPickupLocation(),
                bookingRequest.getDropLocation());

        return BookingDetails.builder()
                .cabDetails(
                        CabDetails.builder()
                                .cabNumber("JH-DS-0082-211")
                        .build()
                )
                .build();
    }

}
