package com.number.guesser.user.service;


import com.number.guesser.user.service.model.SessionData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface SessionService {

    public SessionData getSession(HttpServletRequest httpRequest);

    public SessionData setNickname(String nickname, HttpSession httpSession);

    public String destroySession(HttpSession httpSession);

    public SessionData getSessionData(HttpSession httpSession);

}
