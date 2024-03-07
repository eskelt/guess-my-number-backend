package com.number.guesser.user.web.dto;

import lombok.Data;

import java.util.List;

@Data
public class SessionMessagesDTO {
    private List<String> sessionMessages;
}
