package com.number.guesser.user.web;

import com.number.guesser.user.web.mapper.UserSessionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestController
@RequiredArgsConstructor
public class SseApi {
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();


    private final Map<String, SseEmitter> emitters = new ConcurrentHashMap<>();

    private String lastUser = "";

    private final HttpServletRequest httpServletRequest;

    private final UserSessionMapper userSessionMapper;
    private int count;

    @GetMapping("/api/turnos/{userId}")
    public SseEmitter iniciarSSE(@PathVariable String userId) {
        SseEmitter emitter = new SseEmitter();
        count++;
        emitter.onCompletion(() -> {
            emitters.remove(userId);
            count--;
        });
        emitter.onTimeout(() -> {
            emitters.remove(userId);
            count--;
        });
        emitters.put(userId, emitter);
        iniciarTemporizador(userId);
        enviarEvento(lastUser, userId);
        return emitter;
    }

    public void enviarEvento(String lastUserId, String userId) {
        SseEmitter emitter = emitters.get(lastUserId);
        if (emitter != null) {
            try {
                emitter.send(userId, MediaType.TEXT_PLAIN);
            } catch (IOException e) {
                // Manejar error de envío
                e.printStackTrace();
            }
        }
        this.lastUser = userId;
    }

    public void iniciarTemporizador(String userId) {
        executorService.schedule(() -> {
            enviarEvento(userId, "Tiempo de conexión agotado!");
        }, 25, TimeUnit.SECONDS); // 10 segundos de tiempo de turno
    }
}
