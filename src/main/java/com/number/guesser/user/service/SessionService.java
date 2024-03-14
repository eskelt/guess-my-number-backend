package com.number.guesser.user.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface SessionService {

    public String getSession(HttpServletRequest request);

    public String setNickname(String nickname, HttpServletRequest request);

    public String destroySession(HttpServletRequest request);

    public String getMessages(HttpSession session);

}
