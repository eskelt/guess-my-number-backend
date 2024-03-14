package com.number.guesser.user.service.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class SessionData implements Serializable {
    private String nickname;
}
