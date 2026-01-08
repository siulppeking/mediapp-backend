package com.mitocode.controller;

import com.mitocode.dto.ReservationRequest;
import com.mitocode.dto.ReservationResponse;
import com.mitocode.model.Reservation;
import com.mitocode.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping
    public List<ReservationResponse> getAllReservations() {
        return reservationService.findAll();
    }

    @PostMapping
    public Reservation createReservation(@RequestBody ReservationRequest dto) {
        return reservationService.createReservation(
                dto.getCustomerName(),
                dto.getRoomId(),
                dto.getCheckInDate(),
                dto.getCheckOutDate()
        );
    }
}
