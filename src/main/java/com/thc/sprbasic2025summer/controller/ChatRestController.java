package com.thc.sprbasic2025summer.controller;

import com.thc.sprbasic2025summer.dto.DefaultDto;
import com.thc.sprbasic2025summer.dto.ChatDto;
import com.thc.sprbasic2025summer.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/chat")
@RestController
public class ChatRestController {

    final ChatService chatService;

    /**/

    @PostMapping("")
    public ResponseEntity<DefaultDto.CreateResDto> create(@RequestBody ChatDto.CreateReqDto param){
        return ResponseEntity.ok(chatService.create(param));
    }
    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody ChatDto.UpdateReqDto param){
        chatService.update(param);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody ChatDto.UpdateReqDto param){
        chatService.delete(param);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("")
    public ResponseEntity<ChatDto.DetailResDto> detail(DefaultDto.DetailReqDto param){
        return ResponseEntity.ok(chatService.detail(param));
    }
    @GetMapping("/list")
    public ResponseEntity<List<ChatDto.DetailResDto>> list(ChatDto.ListReqDto param){
        return ResponseEntity.ok(chatService.list(param));
    }
    @GetMapping("/pagedList")
    public ResponseEntity<DefaultDto.PagedListResDto> pagedList(ChatDto.PagedListReqDto param){
        return ResponseEntity.ok(chatService.pagedList(param));
    }
    @GetMapping("/scrollList")
    public ResponseEntity<List<ChatDto.DetailResDto>> scrollList(ChatDto.ScrollListReqDto param){
        return ResponseEntity.ok(chatService.scrollList(param));
    }

}
