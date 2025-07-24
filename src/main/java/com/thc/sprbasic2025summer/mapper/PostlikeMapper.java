package com.thc.sprbasic2025summer.mapper;

import com.thc.sprbasic2025summer.dto.DefaultDto;
import com.thc.sprbasic2025summer.dto.PostlikeDto;

import java.util.List;

public interface PostlikeMapper {
    /**/
    PostlikeDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<PostlikeDto.DetailResDto> list(PostlikeDto.ListReqDto param);
    List<PostlikeDto.DetailResDto> pagedList(PostlikeDto.PagedListReqDto param);
    int pagedListCount(PostlikeDto.PagedListReqDto param);
    List<PostlikeDto.DetailResDto> scrollList(PostlikeDto.ScrollListReqDto param);
}
