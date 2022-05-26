package com.sparta.board.controller;


import com.sparta.board.domain.*;
import com.sparta.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @PostMapping("/api/boards")
    public Board creatBoard(@RequestBody BoardRequestDto requestDto) { //게시글생성
        Board board = new Board(requestDto);
        return boardRepository.save(board);
    }
    @GetMapping("/api/boards/list")
    public List<BoardListRequestDto> readBoardList(){ // 게시글 목록 조회
        return boardService.boardList();
    }
    @GetMapping("/api/boards/details")
    public List<BoardDetailRequestDto> DetailBoardList(){ // 게시글 조회
        return boardService.boardDetail();
    }

    @GetMapping("/api/boards")
    public List<Board> readBoard() { // 전부다 조회
        return boardRepository.findAllByOrderByCreatedAtDesc();
    }

    @PutMapping("/api/boards/{id}") // 비밀번호 비교하여 게시글 수정
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardUpdateRequestDto requestDto) {
        return boardService.update(id, requestDto);
    }

    @DeleteMapping("/api/boards/{id}")
    public Long deleteBoard(@RequestParam("password") String password, @PathVariable Long id) {
        boardService.delete(password, id);
        return id;
    }


}
