package dev.nemowave.saladereuniao.controller;

import dev.nemowave.saladereuniao.model.Room;
import dev.nemowave.saladereuniao.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/room")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RoomController {
    RoomService roomService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Room> getRooms() {
        return roomService.getRooms();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Room getRoom(@PathVariable("id") long id) throws Exception {
        return roomService.getRoom(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoom(@PathVariable("id") long id) throws Exception {
        roomService.deleteRoom(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Room updateRoom(@PathVariable("id") long id, @RequestBody Room room) throws Exception {
        return roomService.updateRoom(id, room);
    }
}
