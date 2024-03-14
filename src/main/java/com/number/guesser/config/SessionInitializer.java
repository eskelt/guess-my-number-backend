package com.number.guesser.config;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

import java.io.ObjectInputFilter;

public class SessionInitializer extends AbstractHttpSessionApplicationInitializer {
    public SessionInitializer() {
        super(ObjectInputFilter.Config.class);
    }

}
