package com.mitocode.service;

import com.mitocode.exception.DomainCustomException;
import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.model.Room;
import com.mitocode.repo.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public Room create(Room room) {
        room.setAvailable(true);
        return roomRepository.save(room);
    }

    public Room updateAvailability(Long id, Boolean available) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new DomainCustomException("Room not found"));

        room.setAvailable(available);
        return roomRepository.save(room);
    }
}
