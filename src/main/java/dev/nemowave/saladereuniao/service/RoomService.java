package dev.nemowave.saladereuniao.service;

import dev.nemowave.saladereuniao.DTO.RoomDTO;
import dev.nemowave.saladereuniao.mapper.RoomMapper;
import dev.nemowave.saladereuniao.model.Room;
import dev.nemowave.saladereuniao.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RoomService {
    RoomRepository roomRepository;

    private final RoomMapper roomMapper = RoomMapper.INSTANCE;

    public List<RoomDTO> getRooms() {
        List<Room> roomList = roomRepository.findAll();

        return roomList.stream()
                .map(roomMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RoomDTO getRoom(long id) throws Exception {
        Room room = verifyIfExists(id);
        return roomMapper.toDTO(room);
    }

    public Room addRoom(RoomDTO room) {
        Room roomToSave = roomMapper.toModel(room);
        return roomRepository.save(roomToSave);
    }

    public void deleteRoom(long id) throws Exception {
        verifyIfExists(id);
        roomRepository.deleteById(id);
    }

    public Room updateRoom(RoomDTO roomDTO) throws Exception {
        verifyIfExists(roomDTO.getId());
        Room roomToUpdate = roomMapper.toModel(roomDTO);
        return roomRepository.save(roomToUpdate);
    }

    private Room verifyIfExists(Long id) throws Exception {
        return roomRepository.findById(id)
                .orElseThrow(Exception::new);
    }

}
