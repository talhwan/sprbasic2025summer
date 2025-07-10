package com.thc.sprbasic2025summer.service;

import com.thc.sprbasic2025summer.dto.BoardDto;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.List;

@Service
public interface BoardService {
    BoardDto.CreateResDto create(BoardDto.CreateReqDto param);
    Map<String, Object> update(BoardDto.UpdateReqDto param);
    Map<String, Object> delete(long id);
    Map<String, Object> detail(long id);
    Map<String, Object> list();
}