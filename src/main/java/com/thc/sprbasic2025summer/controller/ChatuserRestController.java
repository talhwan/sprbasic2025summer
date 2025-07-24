package com.thc.sprbasic2025summer.controller;

import com.thc.sprbasic2025summer.dto.DefaultDto;
import com.thc.sprbasic2025summer.dto.ChatuserDto;
import com.thc.sprbasic2025summer.service.ChatuserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/chatuser")
@RestController
public class ChatuserRestController {

    final ChatuserService chatuserService;

    /**/

    @PostMapping("")
    public ResponseEntity<DefaultDto.CreateResDto> create(@RequestBody ChatuserDto.CreateReqDto param){
        return ResponseEntity.ok(chatuserService.create(param));
    }
    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody ChatuserDto.UpdateReqDto param){
        chatuserService.update(param);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody ChatuserDto.UpdateReqDto param){
        chatuserService.delete(param);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("")
    public ResponseEntity<ChatuserDto.DetailResDto> detail(DefaultDto.DetailReqDto param){
        return ResponseEntity.ok(chatuserService.detail(param));
    }
    @GetMapping("/list")
    public ResponseEntity<List<ChatuserDto.DetailResDto>> list(ChatuserDto.ListReqDto param){
        return ResponseEntity.ok(chatuserService.list(param));
    }
    @GetMapping("/pagedList")
    public ResponseEntity<DefaultDto.PagedListResDto> pagedList(ChatuserDto.PagedListReqDto param){
        return ResponseEntity.ok(chatuserService.pagedList(param));
    }
    @GetMapping("/scrollList")
    public ResponseEntity<List<ChatuserDto.DetailResDto>> scrollList(ChatuserDto.ScrollListReqDto param){
        return ResponseEntity.ok(chatuserService.scrollList(param));
    }

}
