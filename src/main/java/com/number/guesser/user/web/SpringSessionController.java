package com.number.guesser.user.web;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.number.guesser.user.service.SessionService;
import com.number.guesser.user.web.dto.SessionMessagesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class SpringSessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping("/getSession")
    public String getSession(Model model, HttpServletRequest request) {
        return sessionService.getSession(model, request);
    }

    @PostMapping("/persistMessage")
    public String persistMessage(@RequestParam("msg") String msg, HttpServletRequest request) {
        return sessionService.persistMessage(msg, request);
    }

    @PostMapping("/destroySession")
    public String destroySession(HttpServletRequest request) {
        return sessionService.destroySession(request);
    }

    @GetMapping("/getMessages")
    public SessionMessagesDTO getMessages(HttpSession session) {
        SessionMessagesDTO dto = sessionService.getMessages(session);
        return null;
    }

}