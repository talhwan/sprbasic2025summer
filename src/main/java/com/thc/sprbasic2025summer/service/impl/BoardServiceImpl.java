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
    public void update(BoardDto.UpdateReqDto param) {
        Board board = boardRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        if(param.getTitle() != null){ board.setTitle(param.getTitle()); }
        if(param.getContent() != null){ board.setContent(param.getContent()); }
        if(param.getAuthor() != null){ board.setAuthor(param.getAuthor()); }
        boardRepository.save(board);
    }

    @Override
    public void delete(long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("no data"));
        boardRepository.delete(board);
    }

    public BoardDto.DetailResDto get(long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("no data"));
        return BoardDto.DetailResDto.builder().id(board.getId())
                .title(board.getTitle()).content(board.getContent()).author(board.getAuthor())
                .build();
    }

    @Override
    public BoardDto.DetailResDto detail(long id) {
        return get(id);
    }
    @Override
    public List<BoardDto.DetailResDto> list() {
        List<BoardDto.DetailResDto> resultList = new ArrayList<>();
        List<Board> list = boardRepository.findAll();
        for(Board each : list){
            resultList.add(get(each.getId()));
        }
        return resultList;
    }
}
