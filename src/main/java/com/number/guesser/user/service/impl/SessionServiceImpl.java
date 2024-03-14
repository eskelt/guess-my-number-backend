package com.number.guesser.user.service.impl;

import com.number.guesser.user.service.SessionService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class SessionServiceImpl implements SessionService {

    public String getSession(HttpServletRequest request) {
        //HttpSession session = request.getSession();
        //regenerateSession(request);
        //return session.getId();
        return null;
    }

    public String setNickname(String msg, HttpServletRequest request) {
        /*@SuppressWarnings("unchecked")
        List<String> messages = (List<String>) request.getSession().getAttribute(SessionConstants.SESSION_MESSAGES);
        if (messages == null) {
            messages = new ArrayList<>();
            request.getSession().setAttribute(SessionConstants.SESSION_MESSAGES, messages);
        }
        messages.add(msg);
        request.getSession().setAttribute(SessionConstants.SESSION_MESSAGES, messages);
        return SessionConstants.MSG_ADDED;*/
        return null;
    }

    public String destroySession(HttpServletRequest request) {
        /*request.getSession().invalidate();
        return SessionConstants.SESSION_DESTROYED;*/
        return null;
    }

    public String getMessages(HttpSession session) {
        /*SessionMessagesDTO sessionMessages = new SessionMessagesDTO();
        sessionMessages.setSessionMessages((List<String>)session.getAttribute(SessionConstants.SESSION_MESSAGES));
        return sessionMessages;*/
        return null;
    }

    private void regenerateSession(HttpServletRequest request) {
        /*HttpSession oldSession = request.getSession();

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
        }*/
    }

}
