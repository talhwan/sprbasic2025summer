package com.thc.sprbasic2025summer.controller;

import com.thc.sprbasic2025summer.dto.DefaultDto;
import com.thc.sprbasic2025summer.dto.PostimgDto;
import com.thc.sprbasic2025summer.service.PostimgService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/postimg")
@RestController
public class PostimgRestController {

    final PostimgService postimgService;

    /**/

    @PostMapping("")
    public ResponseEntity<DefaultDto.CreateResDto> create(@RequestBody PostimgDto.CreateReqDto param){
        return ResponseEntity.ok(postimgService.create(param));
    }
    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody PostimgDto.UpdateReqDto param){
        postimgService.update(param);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody PostimgDto.UpdateReqDto param){
        postimgService.delete(param);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("")
    public ResponseEntity<PostimgDto.DetailResDto> detail(DefaultDto.DetailReqDto param){
        return ResponseEntity.ok(postimgService.detail(param));
    }
    @GetMapping("/list")
    public ResponseEntity<List<PostimgDto.DetailResDto>> list(PostimgDto.ListReqDto param){
        return ResponseEntity.ok(postimgService.list(param));
    }
    @GetMapping("/pagedList")
    public ResponseEntity<DefaultDto.PagedListResDto> pagedList(PostimgDto.PagedListReqDto param){
        return ResponseEntity.ok(postimgService.pagedList(param));
    }
    @GetMapping("/scrollList")
    public ResponseEntity<List<PostimgDto.DetailResDto>> scrollList(PostimgDto.ScrollListReqDto param){
        return ResponseEntity.ok(postimgService.scrollList(param));
    }

}
