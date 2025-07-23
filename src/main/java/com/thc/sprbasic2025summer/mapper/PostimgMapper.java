package com.thc.sprbasic2025summer.mapper;

import com.thc.sprbasic2025summer.dto.DefaultDto;
import com.thc.sprbasic2025summer.dto.PostimgDto;

import java.util.List;

public interface PostimgMapper {
    /**/
    PostimgDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<PostimgDto.DetailResDto> list(PostimgDto.ListReqDto param);
    List<PostimgDto.DetailResDto> pagedList(PostimgDto.PagedListReqDto param);
    int pagedListCount(PostimgDto.PagedListReqDto param);
    List<PostimgDto.DetailResDto> scrollList(PostimgDto.ScrollListReqDto param);
}
