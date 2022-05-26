package com.sparta.board.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BoardRequestDto {
    private final String title;

    private final String name;

    private final String content;

    private final String password;


    public BoardRequestDto(String title, String name, String content, String password) {
        this.title = title;
        this.name = name;
        this.content = content;
        this.password = password;
    }
}
