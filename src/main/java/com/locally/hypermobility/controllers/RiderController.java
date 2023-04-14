package com.locally.hypermobility.controllers;

import com.locally.hypermobility.models.BookingDetails;
import com.locally.hypermobility.services.CabFinderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.domain.geo.GeoLocation;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/customer")
@RequiredArgsConstructor
public class RiderController {

    private final CabFinderService cabFinderService;

    @MessageMapping("/book-cab")
    @SendTo("/topic/book-cab")
    public BookingDetails bookACab(String riderId, GeoLocation pickupLocation, GeoLocation dropLocation) {

        return cabFinderService.bookCabForRider(riderId, pickupLocation, dropLocation);
    }


}
