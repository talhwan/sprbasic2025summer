package com.thc.sprbasic2025summer.controller;

import com.thc.sprbasic2025summer.dto.ChattalkDto;
import com.thc.sprbasic2025summer.dto.DefaultDto;
import com.thc.sprbasic2025summer.service.ChattalkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/chattalk")
@RestController
public class ChattalkRestController {

    final ChattalkService chattalkService;

    /**/

    @PostMapping("")
    public ResponseEntity<DefaultDto.CreateResDto> create(@RequestBody ChattalkDto.CreateReqDto param){
        return ResponseEntity.ok(chattalkService.create(param));
    }
    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody ChattalkDto.UpdateReqDto param){
        chattalkService.update(param);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody ChattalkDto.UpdateReqDto param){
        chattalkService.delete(param);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("")
    public ResponseEntity<ChattalkDto.DetailResDto> detail(DefaultDto.DetailReqDto param){
        return ResponseEntity.ok(chattalkService.detail(param));
    }
    @GetMapping("/list")
    public ResponseEntity<List<ChattalkDto.DetailResDto>> list(ChattalkDto.ListReqDto param){
        return ResponseEntity.ok(chattalkService.list(param));
    }
    @GetMapping("/pagedList")
    public ResponseEntity<DefaultDto.PagedListResDto> pagedList(ChattalkDto.PagedListReqDto param){
        return ResponseEntity.ok(chattalkService.pagedList(param));
    }
    @GetMapping("/scrollList")
    public ResponseEntity<List<ChattalkDto.DetailResDto>> scrollList(ChattalkDto.ScrollListReqDto param){
        return ResponseEntity.ok(chattalkService.scrollList(param));
    }

}
