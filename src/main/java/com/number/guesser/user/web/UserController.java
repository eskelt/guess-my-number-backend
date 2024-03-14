package com.number.guesser.user.web;

import javax.servlet.http.HttpServletRequest;

import com.number.guesser.api.UserApi;
import com.number.guesser.api.model.SessionDataDTO;
import com.number.guesser.user.service.SessionService;
import com.number.guesser.user.service.model.SessionData;
import com.number.guesser.user.web.mapper.UserSessionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final SessionService sessionService;

    private final HttpServletRequest httpServletRequest;

    private final UserSessionMapper userSessionMapper;

    public ResponseEntity<SessionDataDTO> getSession() {
        SessionData data = sessionService.getSession(httpServletRequest);
        SessionDataDTO dataDto = userSessionMapper.sessionDataToSessionDataDTO(data);
        return ResponseEntity.ok(dataDto);
    }

    @Override
    public ResponseEntity<String> destroySession() {
        return ResponseEntity.ok(sessionService.destroySession(httpServletRequest.getSession()));
    }

    @Override
    public ResponseEntity<SessionDataDTO> getSessionData() {
        return ResponseEntity.ok(userSessionMapper.sessionDataToSessionDataDTO(sessionService.getSessionData(httpServletRequest.getSession())));
    }

    @Override
    public ResponseEntity<SessionDataDTO> setNickname(String nickname) {
        return ResponseEntity.ok(userSessionMapper.sessionDataToSessionDataDTO(sessionService.setNickname(nickname, httpServletRequest.getSession())));
    }
}