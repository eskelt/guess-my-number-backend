package com.number.guesser.user.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.number.guesser.api.UserApi;
import com.number.guesser.api.model.SessionDataDTO;
import com.number.guesser.user.service.impl.SessionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController implements UserApi {

    @Autowired
    private HttpSession session;

    @Autowired
    private HttpServletRequest httpRequest;

    @Autowired
    private SessionServiceImpl sessionService;


    public ResponseEntity<SessionDataDTO> getSession() {
        sessionService.getSession(httpRequest);
        return null;
    }

    @Override
    public ResponseEntity<String> destroySession(String httpServletRequest) {
        return ResponseEntity.ok(sessionService.destroySession(httpRequest));
    }

    @Override
    public ResponseEntity<SessionDataDTO> getSessionData() {
        return null;
    }

    @Override
    public ResponseEntity<SessionDataDTO> setNickname(String nickname) {
        return null;
    }
}