package com.thc.sprbasic2025summer.service;

import com.thc.sprbasic2025summer.dto.BoardDto;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.List;

@Service
public interface BoardService {
    BoardDto.CreateResDto create(BoardDto.CreateReqDto param);
    void update(BoardDto.UpdateReqDto param);
    void delete(long id);
    BoardDto.DetailResDto detail(long id);
    List<BoardDto.DetailResDto> list();
}