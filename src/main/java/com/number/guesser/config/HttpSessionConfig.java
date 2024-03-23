package com.number.guesser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;

@Configuration(proxyBeanMethods = false)
@EnableRedisHttpSession
public class HttpSessionConfig {
    // Configuración adicional si es necesario
    @Bean
    public LettuceConnectionFactory connectionFactory() {
        return new LettuceConnectionFactory();
    }

    @Bean
    RedisMessageListenerContainer keyExpirationListenerContainer(RedisConnectionFactory connectionFactory
    ) {
        RedisMessageListenerContainer listenerContainer = new RedisMessageListenerContainer();
        listenerContainer.setConnectionFactory(connectionFactory);
        listenerContainer.addMessageListener((message, pattern) -> {
            System.out.println("----------------");
            System.out.println("----------------");
            System.out.println("----------------");
            System.out.println("CADUCO LA COOKIE");
            System.out.println("----------------");
            System.out.println("----------------");
            System.out.println("----------------");
            System.out.println("Message: " + new String(message.getBody(), StandardCharsets.UTF_8));
            System.out.println("pattern: " + new String(pattern, StandardCharsets.UTF_8));

        }, new PatternTopic("__keyevent@*__:expired"));

        return listenerContainer;
    }

}