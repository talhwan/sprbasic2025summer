package com.thc.sprbasic2025summer.service.impl;

import com.thc.sprbasic2025summer.domain.Board;
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
    public Map<String, Object> create(Map<String, Object> param) {
        String title = param.get("title").toString();
        String content = param.get("content").toString();
        String author = param.get("author").toString();

        Board board = Board.of(title, content, author);
        boardRepository.save(board);

        Map<String,Object> map_result = new HashMap<>();
        map_result.put("code", 200);
        return map_result;
    }

    @Override
    public Map<String, Object> update(Map<String, Object> param) {
        int code = 200;
        long id = Long.parseLong(param.get("id").toString());
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("no data"));
        if(param.get("title") != null){ board.setTitle((String) param.get("title")); }
        if(param.get("content") != null){ board.setContent((String) param.get("content")); }
        if(param.get("author") != null){ board.setAuthor((String) param.get("author")); }
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
