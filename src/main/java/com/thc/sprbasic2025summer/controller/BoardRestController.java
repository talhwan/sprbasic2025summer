package com.thc.sprbasic2025summer.controller;

import com.thc.sprbasic2025summer.dto.BoardDto;
import com.thc.sprbasic2025summer.dto.DefaultDto;
import com.thc.sprbasic2025summer.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequiredArgsConstructor
@RequestMapping("/api/board")
@RestController
public class BoardRestController {

    final BoardService boardService;

    @PostMapping("")
    public DefaultDto.CreateResDto create(@RequestBody BoardDto.CreateReqDto param){
        return boardService.create(param);
    }
    @PutMapping("")
    public void update(@RequestBody BoardDto.UpdateReqDto param){
        boardService.update(param);
    }
    @DeleteMapping("")
    public void delete(@RequestBody BoardDto.UpdateReqDto param){
        boardService.delete(param.getId());
    }

    @GetMapping("/detail/{id}")
    public BoardDto.DetailResDto detail(@PathVariable long id){
        return boardService.detail(id);
    }
    @GetMapping("/list")
    public List<BoardDto.DetailResDto> list(){
        return boardService.list();
    }

}
