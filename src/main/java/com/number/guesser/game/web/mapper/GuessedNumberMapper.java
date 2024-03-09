package com.number.guesser.game.web.mapper;

import com.number.guesser.game.repository.entity.RoomEntity;
import com.number.guesser.game.web.dto.GuessedNumberDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public abstract class GuessedNumberMapper {

    @Mapping(target = "roomId", source = "id")
    @Mapping(target = "roomName", source = "name")
    abstract GuessedNumberDTO RoomEntityToGuessedNumberDTO(RoomEntity dto);

    @AfterMapping
    protected void roomEntityToGuessedNumberDTOAfterMapping(RoomEntity source, @MappingTarget GuessedNumberDTO target){
        target.setRoomId(source.getId() + 1);
    }


}
