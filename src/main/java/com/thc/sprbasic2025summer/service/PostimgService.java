package com.thc.sprbasic2025summer.service;

import com.thc.sprbasic2025summer.dto.DefaultDto;
import com.thc.sprbasic2025summer.dto.PostimgDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostimgService {
    /**/
    DefaultDto.CreateResDto create(PostimgDto.CreateReqDto param);
    void update(PostimgDto.UpdateReqDto param);
    void delete(PostimgDto.UpdateReqDto param);
    PostimgDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<PostimgDto.DetailResDto> list(PostimgDto.ListReqDto param);
    DefaultDto.PagedListResDto pagedList(PostimgDto.PagedListReqDto param);
    List<PostimgDto.DetailResDto> scrollList(PostimgDto.ScrollListReqDto param);
}