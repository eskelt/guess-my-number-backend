package com.number.guesser.configuration;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

import java.io.ObjectInputFilter;

public class SessionInitializer extends AbstractHttpSessionApplicationInitializer {
    public SessionInitializer() {
        super(ObjectInputFilter.Config.class);
    }

}
