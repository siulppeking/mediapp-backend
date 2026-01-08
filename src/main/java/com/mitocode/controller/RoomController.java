package com.mitocode.controller;

import com.mitocode.model.Room;
import com.mitocode.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.findAll();
    }

    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return roomService.create(room);
    }

    @PutMapping("/{id}")
    public Room updateAvailability(
            @PathVariable Long id,
            @RequestParam Boolean available
    ) {
        return roomService.updateAvailability(id, available);
    }
}

