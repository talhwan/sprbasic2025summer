package com.thc.sprbasic2025summer.controller;

import com.thc.sprbasic2025summer.dto.DefaultDto;
import com.thc.sprbasic2025summer.dto.PostlikeDto;
import com.thc.sprbasic2025summer.service.PostlikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/postlike")
@RestController
public class PostlikeRestController {

    final PostlikeService postlikeService;
    @GetMapping("/watch")
    public ResponseEntity<PostlikeDto.WatchResDto> watch(PostlikeDto.WatchReqDto param){
        return ResponseEntity.ok(postlikeService.watch(param));
    }

    @PostMapping("/toggle")
    public ResponseEntity<PostlikeDto.ToggleResDto> toggle(@RequestBody PostlikeDto.ToggleReqDto param){
        return ResponseEntity.ok(postlikeService.toggle(param));
    }

    /**/

    @PostMapping("")
    public ResponseEntity<DefaultDto.CreateResDto> create(@RequestBody PostlikeDto.CreateReqDto param){
        return ResponseEntity.ok(postlikeService.create(param));
    }
    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody PostlikeDto.UpdateReqDto param){
        postlikeService.update(param);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody PostlikeDto.UpdateReqDto param){
        postlikeService.delete(param);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("")
    public ResponseEntity<PostlikeDto.DetailResDto> detail(DefaultDto.DetailReqDto param){
        return ResponseEntity.ok(postlikeService.detail(param));
    }
    @GetMapping("/list")
    public ResponseEntity<List<PostlikeDto.DetailResDto>> list(PostlikeDto.ListReqDto param){
        return ResponseEntity.ok(postlikeService.list(param));
    }
    @GetMapping("/pagedList")
    public ResponseEntity<DefaultDto.PagedListResDto> pagedList(PostlikeDto.PagedListReqDto param){
        return ResponseEntity.ok(postlikeService.pagedList(param));
    }
    @GetMapping("/scrollList")
    public ResponseEntity<List<PostlikeDto.DetailResDto>> scrollList(PostlikeDto.ScrollListReqDto param){
        return ResponseEntity.ok(postlikeService.scrollList(param));
    }

}
