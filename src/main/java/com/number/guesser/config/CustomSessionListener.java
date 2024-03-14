package com.number.guesser.config;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class CustomSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(final HttpSessionEvent se) {
        System.out.println("SESION CREADA");
    }

    @Override
    public void sessionDestroyed(final HttpSessionEvent se) {
        System.out.println("SESION DESTRUIDA");
    }
}
