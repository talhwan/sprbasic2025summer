package com.thc.sprbasic2025summer.service;

import com.thc.sprbasic2025summer.dto.DefaultDto;
import com.thc.sprbasic2025summer.dto.PostlikeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostlikeService {
    PostlikeDto.WatchResDto watch(PostlikeDto.WatchReqDto param);
    PostlikeDto.ToggleResDto toggle(PostlikeDto.ToggleReqDto param);
    /**/
    DefaultDto.CreateResDto create(PostlikeDto.CreateReqDto param);
    void update(PostlikeDto.UpdateReqDto param);
    void delete(PostlikeDto.UpdateReqDto param);
    PostlikeDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<PostlikeDto.DetailResDto> list(PostlikeDto.ListReqDto param);
    DefaultDto.PagedListResDto pagedList(PostlikeDto.PagedListReqDto param);
    List<PostlikeDto.DetailResDto> scrollList(PostlikeDto.ScrollListReqDto param);
}