package dev.nemowave.saladereuniao.mapper;

import dev.nemowave.saladereuniao.DTO.RoomDTO;
import dev.nemowave.saladereuniao.model.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper {
    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    @Mapping(target = "date", source = "date", dateFormat = "dd-MM-yyyy")
    Room toModel(RoomDTO roomDTO);
    RoomDTO toDTO(Room room);
}
