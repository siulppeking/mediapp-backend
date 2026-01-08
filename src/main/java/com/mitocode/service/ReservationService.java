package com.mitocode.service;

import com.mitocode.dto.ReservationResponse;
import com.mitocode.exception.DomainCustomException;
import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.model.Reservation;
import com.mitocode.model.Room;
import com.mitocode.repo.ReservationRepository;
import com.mitocode.repo.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;

    public List<ReservationResponse> findAll() {
        return reservationRepository.findAll()
                .stream()
                .map(r -> new ReservationResponse(
                        r.getId(),
                        r.getCustomerName(),
                        r.getCheckInDate(),
                        r.getCheckOutDate(),
                        r.getRoom().getId(),
                        r.getRoom().getNumber(),
                        r.getRoom().getType()
                ))
                .toList();
    }


    public Reservation createReservation(
            String customerName,
            Long roomId,
            LocalDate checkIn,
            LocalDate checkOut
    ) {

        if (checkOut.isBefore(checkIn)) {
            throw new DomainCustomException("Check-out cannot be before check-in");
        }

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ModelNotFoundException("Room not found"));

        if (!room.getAvailable()) {
            throw new DomainCustomException("Room is not available");
        }

        List<Reservation> conflicts =
                reservationRepository.findConflictingReservations(
                        roomId, checkIn, checkOut
                );

        if (!conflicts.isEmpty()) {
            throw new DomainCustomException("Room already reserved for selected dates");
        }

        Reservation reservation = Reservation.builder()
                .customerName(customerName)
                .checkInDate(checkIn)
                .checkOutDate(checkOut)
                .room(room)
                .build();

        room.setAvailable(false);

        return reservationRepository.save(reservation);
    }
}

