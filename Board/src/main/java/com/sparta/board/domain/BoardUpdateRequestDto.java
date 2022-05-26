package com.sparta.board.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardUpdateRequestDto {
    private final String title;

    private final String content;

    private final String password;


    public BoardUpdateRequestDto(String title, String content, String password) {
        this.title = title;
        this.content = content;
        this.password = password;
    }
}
