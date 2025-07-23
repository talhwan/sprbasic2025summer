package com.thc.sprbasic2025summer.mapper;

import com.thc.sprbasic2025summer.dto.DefaultDto;
import com.thc.sprbasic2025summer.dto.PostDto;

import java.util.List;

public interface PostMapper {
    /**/
    PostDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<PostDto.DetailResDto> list(PostDto.ListReqDto param);
    List<PostDto.DetailResDto> pagedList(PostDto.PagedListReqDto param);
    int pagedListCount(PostDto.PagedListReqDto param);
    List<PostDto.DetailResDto> scrollList(PostDto.ScrollListReqDto param);
}
