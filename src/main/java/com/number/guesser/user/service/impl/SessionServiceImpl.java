package com.number.guesser.user.service.impl;

import com.number.guesser.user.constants.SessionConstants;
import com.number.guesser.user.service.SessionService;
import com.number.guesser.user.service.model.SessionData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    public SessionData getSession(HttpServletRequest httpRequest) {
        HttpSession httpSession = httpRequest.getSession();
        System.out.println("MAX: " + httpSession.getMaxInactiveInterval());
        System.out.println("SESSIONID: " + httpSession.getId());
        System.out.println("SESSIONID: " + httpRequest.getCookies().length);
        System.out.println("SESSIONID: " + httpRequest.getCookies()[0].getName());
        System.out.println("SESSIONID: " + httpRequest.getCookies()[0].getValue());
        System.out.println("--------------------------------------------------------");
        SessionData sessionData = (SessionData)httpSession.getAttribute(SessionConstants.SESSION_DATA);
        if(sessionData == null){
            sessionData = new SessionData();
            httpSession.setAttribute(SessionConstants.SESSION_DATA, sessionData);
        }
        return sessionData;
    }

    public SessionData setNickname(String nickname, HttpSession httpSession) {
        SessionData sessionData = (SessionData)httpSession.getAttribute(SessionConstants.SESSION_DATA);
        sessionData.setNickname(nickname);
        httpSession.setAttribute(SessionConstants.SESSION_DATA, sessionData);
        return sessionData;
    }

    @Override
    public String destroySession(HttpSession httpSession) {
        httpSession.invalidate();
        return SessionConstants.SESSION_DESTROYED;
    }

    @Override
    public SessionData getSessionData(HttpSession httpSession) {
        return (SessionData)httpSession.getAttribute(SessionConstants.SESSION_DATA);
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
