package com.thc.sprbasic2025summer.service.impl;

import com.thc.sprbasic2025summer.domain.Board;
import com.thc.sprbasic2025summer.dto.BoardCreateReqDto;
import com.thc.sprbasic2025summer.dto.BoardDto;
import com.thc.sprbasic2025summer.repository.BoardRepository;
import com.thc.sprbasic2025summer.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    final BoardRepository boardRepository;

    @Override
    public BoardDto.CreateResDto create(BoardDto.CreateReqDto param) {
        String title = param.getTitle();
        String content = param.getContent();
        String author = param.getAuthor();

        Board board = Board.of(title, content, author);
        board = boardRepository.save(board);

        /*
        1번 방법
        BoardDto.CreateResDto resDto = new BoardDto.CreateResDto();
        resDto.setId(board.getId());

        2번 방법
        BoardDto.CreateResDto resDto =
                BoardDto.CreateResDto.builder().id(board.getId()).build();
        */
        return BoardDto.CreateResDto.builder().id(board.getId()).build();
    }

    @Override
    public Map<String, Object> update(BoardDto.UpdateReqDto param) {
        int code = 200;
        long id = param.getId();
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("no data"));
        if(param.getTitle() != null){ board.setTitle(param.getTitle()); }
        if(param.getContent() != null){ board.setContent(param.getContent()); }
        if(param.getAuthor() != null){ board.setAuthor(param.getAuthor()); }
        boardRepository.save(board);

        Map<String,Object> map_result = new HashMap<>();
        map_result.put("code", code);
        return map_result;
    }

    @Override
    public Map<String, Object> delete(long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("no data"));
        boardRepository.delete(board);

        int code = 200;
        Map<String,Object> map_result = new HashMap<>();
        map_result.put("code", code);
        return map_result;
    }

    @Override
    public Map<String, Object> detail(long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("no data"));

        int resultCode = 200;
        Map<String,Object> map_result = new HashMap<>();
        map_result.put("code", resultCode);
        map_result.put("board", board);
        return map_result;
    }

    @Override
    public Map<String, Object> list() {
        List<Board> list = boardRepository.findAll();
        Map<String,Object> map_result = new HashMap<>();
        map_result.put("code", 200);
        map_result.put("list", list);
        return map_result;
    }
}
