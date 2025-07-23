package com.thc.sprbasic2025summer.controller;

import com.thc.sprbasic2025summer.dto.DefaultDto;
import com.thc.sprbasic2025summer.dto.PostDto;
import com.thc.sprbasic2025summer.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/post")
@RestController
public class PostRestController {

    final PostService postService;

    /**/

    @PostMapping("")
    public ResponseEntity<DefaultDto.CreateResDto> create(@RequestBody PostDto.CreateReqDto param){
        return ResponseEntity.ok(postService.create(param));
    }
    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody PostDto.UpdateReqDto param){
        postService.update(param);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody PostDto.UpdateReqDto param){
        postService.delete(param);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("")
    public ResponseEntity<PostDto.DetailResDto> detail(DefaultDto.DetailReqDto param){
        return ResponseEntity.ok(postService.detail(param));
    }
    @GetMapping("/list")
    public ResponseEntity<List<PostDto.DetailResDto>> list(PostDto.ListReqDto param){
        return ResponseEntity.ok(postService.list(param));
    }
    @GetMapping("/pagedList")
    public ResponseEntity<DefaultDto.PagedListResDto> pagedList(PostDto.PagedListReqDto param){
        return ResponseEntity.ok(postService.pagedList(param));
    }
    @GetMapping("/scrollList")
    public ResponseEntity<List<PostDto.DetailResDto>> scrollList(PostDto.ScrollListReqDto param){
        return ResponseEntity.ok(postService.scrollList(param));
    }

}
