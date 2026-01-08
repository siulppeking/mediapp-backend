package com.mitocode.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReservationRequest {

    private String customerName;
    private Long roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

}
