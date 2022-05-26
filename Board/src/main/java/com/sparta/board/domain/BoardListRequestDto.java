package com.sparta.board.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;

@Setter
@Getter
public class BoardListRequestDto {
    private String title;

    private String name;

    @CreatedDate
    private LocalDateTime createdAt;

    public BoardListRequestDto(String title, String name, LocalDateTime createdAt) {
        this.title = title;
        this.name = name;
        this.createdAt = createdAt;
    }
}
