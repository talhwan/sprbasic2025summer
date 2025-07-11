package com.thc.sprbasic2025summer.controller;

import com.thc.sprbasic2025summer.dto.BoardDto;
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
    public BoardDto.CreateResDto create(@RequestBody BoardDto.CreateReqDto param){
        return boardService.create(param);
    }
    @PutMapping("")
    public Map<String, Object> update(@RequestBody BoardDto.UpdateReqDto param){
        return boardService.update(param);
    }
    @DeleteMapping("")
    public Map<String, Object> delete(@RequestBody Map<String, Object> param){
        Long id = Long.parseLong(param.get("id").toString());
        return boardService.delete(id);
    }

    @GetMapping("/detail/{id}")
    public Map<String, Object> detail(@PathVariable long id){
        return boardService.detail(id);
    }
    @GetMapping("/list")
    public Map<String, Object> list(){
        return boardService.list();
    }

}
