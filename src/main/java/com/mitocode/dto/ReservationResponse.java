package com.mitocode.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ReservationResponse {

    private Long id;
    private String customerName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    private Long roomId;
    private String roomNumber;
    private String roomType;

}
