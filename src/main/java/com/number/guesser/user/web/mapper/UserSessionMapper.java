package com.number.guesser.user.web.mapper;

import com.number.guesser.api.model.SessionDataDTO;
import com.number.guesser.user.service.model.SessionData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserSessionMapper {

    public abstract SessionDataDTO sessionDataToSessionDataDTO(SessionData dto);

}
