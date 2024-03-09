package com.number.guesser.game.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;


@RestController
@RequestMapping("/api/game")
public class NumberGuesserController {

    @GetMapping("/hello")
    public String getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        return "Hello World";
    }

}