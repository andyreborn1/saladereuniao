package dev.nemowave.saladereuniao.service;

import dev.nemowave.saladereuniao.exception.ResourceNotFoundException;
import dev.nemowave.saladereuniao.model.Room;
import dev.nemowave.saladereuniao.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RoomService {
    RoomRepository roomRepository;

    public List<Room> getRooms() {
        List<Room> roomList = roomRepository.findAll();

        return roomList;
    }

    public Room getRoom(long id) throws Exception {
        Room room = verifyIfExists(id);
        return room;
    }

    public Room addRoom(Room room) {
        Room savedRoom = roomRepository.save(room);
        return savedRoom;
    }

    public void deleteRoom(long id) throws Exception {
        verifyIfExists(id);
        roomRepository.deleteById(id);
    }

    public Room updateRoom(long id, Room room) throws Exception {
        verifyIfExists(id);
        if(id!=room.getId()){
            throw  new Exception("Inconsitencia de ID");
        }

        Room updatedRoom = roomRepository.save(room);
        return updatedRoom;
    }

    private Room verifyIfExists(Long id) throws Exception {
        return roomRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

}
