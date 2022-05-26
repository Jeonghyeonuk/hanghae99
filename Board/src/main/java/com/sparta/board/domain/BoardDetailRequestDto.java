package com.sparta.board.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;


@Getter
@Setter
public class BoardDetailRequestDto {
    private String title;

    private String name;

    private String content;
    @CreatedDate
    private LocalDateTime createdAt;

    public BoardDetailRequestDto(String title, String name, String content, LocalDateTime createdAt) {
        this.title = title;
        this.name = name;
        this.content = content;
        this.createdAt = createdAt;
    }



}
