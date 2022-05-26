package com.sparta.board.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
//@setter 무조건 없어야함.
public class Board extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String content;


    public Board(BoardRequestDto requestDto) { // post하기위해서 만듦
        this.title = requestDto.getTitle();
        this.name = requestDto.getName();
        this.password = requestDto.getPassword();
        this.content = requestDto.getContent();
    }

    public void update(BoardUpdateRequestDto requestDto){ // 업데이트
        this.content = requestDto.getContent();
        this.title = requestDto.getTitle();
        this.password =requestDto.getPassword();
    }


}
