package com.sparta.board.service;


import com.sparta.board.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long update(Long id, BoardUpdateRequestDto requestDto) { //업데이트
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("게시글이 존재하지 않습니다.") // 일단 id값으로 맞는 데이터를 꺼내서
        );
        if (board.getPassword().equals(requestDto.getPassword())) { // 꺼낸 데이터의 비밀번호와 받아온 데이터의 비밀번호가 일치한경우
            board.update(requestDto); //업데이트실행
            return board.getId();
        } else {
            System.out.println("비밀번호가 잘못되었습니다."); // 아니면 오류메세지띄우기
        }
        return id;
    }

    @Transactional
    public List<BoardListRequestDto> boardList() { // 게시글 목록 조회
        List<Board> boardList = boardRepository.findAllByOrderByCreatedAtDesc();
        List<BoardListRequestDto> boardListRequestDtoArrayList = new ArrayList<>();
        for (int i = 0; i < boardList.size(); i++) {
            Board board = boardList.get(i);
            BoardListRequestDto boardListRequestDto = new BoardListRequestDto(board.getTitle(), board.getName(), board.getCreatedAt());
            boardListRequestDtoArrayList.add(boardListRequestDto);
        }
        return boardListRequestDtoArrayList;
    }

    @Transactional
    public List<BoardDetailRequestDto> boardDetail() { // 게시글 조회
        List<Board> boardDetail = boardRepository.findAllByOrderByCreatedAtDesc();
        List<BoardDetailRequestDto> boardDetilRequestDtoArrayList = new ArrayList<>();
        for (int i = 0; i < boardDetail.size(); i++) {
            Board board = boardDetail.get(i);
            BoardDetailRequestDto boardDetailRequestDto = new BoardDetailRequestDto(board.getTitle(), board.getName(), board.getContent(), board.getCreatedAt());
            boardDetilRequestDtoArrayList.add(boardDetailRequestDto);
        }
        return boardDetilRequestDtoArrayList;
    }

    @Transactional
    public Long delete(String password, Long id) { // 게시글 삭제
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("게시글이 존재하지 않습니다.")
        );
        if (password.equals(board.getPassword())) {
            boardRepository.deleteById(id);
            return id;
        } else {
            System.out.println("비밀번호가 잘못되었습니다.");
        }
        return id;
    }
}
