package com.number.guesser.user.service;

import com.number.guesser.user.constants.SessionConstants;
import com.number.guesser.user.web.dto.SessionMessagesDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

@Service
public class SessionService {

    @GetMapping("/getSession")
    public String getSession(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<String> messages = (List<String>) session.getAttribute(SessionConstants.SESSION_MESSAGES);
        if (messages == null) {
            messages = new ArrayList<>();
        }
        model.addAttribute(SessionConstants.SESSION_MESSAGES, messages);
        //regenerateSession(request);
        return session.getId();
    }

    @PostMapping("/persistMessage")
    public String persistMessage(@RequestParam("msg") String msg, HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        List<String> messages = (List<String>) request.getSession().getAttribute(SessionConstants.SESSION_MESSAGES);
        if (messages == null) {
            messages = new ArrayList<>();
            request.getSession().setAttribute(SessionConstants.SESSION_MESSAGES, messages);
        }
        messages.add(msg);
        request.getSession().setAttribute(SessionConstants.SESSION_MESSAGES, messages);
        return SessionConstants.MSG_ADDED;
    }

    @PostMapping("/destroySession")
    public String destroySession(HttpServletRequest request) {
        request.getSession().invalidate();
        return SessionConstants.SESSION_DESTROYED;
    }

    @GetMapping(value = "/getMessages", consumes="application/json")
    public SessionMessagesDTO getMessages(HttpSession session) {
        SessionMessagesDTO sessionMessages = new SessionMessagesDTO();
        sessionMessages.setSessionMessages((List<String>)session.getAttribute(SessionConstants.SESSION_MESSAGES));
        return sessionMessages;
    }

    private void regenerateSession(HttpServletRequest request) {
        HttpSession oldSession = request.getSession();

        Enumeration attrNames = oldSession.getAttributeNames();
        Properties props = new Properties();

        if (attrNames != null) {
            while (attrNames.hasMoreElements()) {
                String key = (String) attrNames.nextElement();
                props.put(key, oldSession.getAttribute(key));
            }

            //Invalidating previous session
            oldSession.invalidate();
            //Generate new session
            HttpSession newSession = request.getSession(true);
            attrNames = props.keys();

            while (attrNames.hasMoreElements()) {
                String key = (String) attrNames.nextElement();
                newSession.setAttribute(key, props.get(key));
            }
        }
    }

}
